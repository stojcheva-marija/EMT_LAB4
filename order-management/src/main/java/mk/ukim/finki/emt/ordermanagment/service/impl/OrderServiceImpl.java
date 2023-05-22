package mk.ukim.finki.emt.ordermanagment.service.impl;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.ordermanagment.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermanagment.domain.exceptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.ordermanagment.domain.model.Order;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderItemId;
import mk.ukim.finki.emt.ordermanagment.repository.OrderRepository;
import mk.ukim.finki.emt.ordermanagment.service.OrderService;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderForm;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderItemForm;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final DomainEventPublisher domainEventPublisher;
    private final Validator validator;

    @Override
    public OrderId placeOrder(OrderForm orderForm) {
        Objects.requireNonNull(orderForm,"order must not be null.");
        var constraintViolations = validator.validate(orderForm);
        if (constraintViolations.size()>0) {
            throw new ConstraintViolationException("The order form is not valid", constraintViolations);
        }
        var newOrder = orderRepository.saveAndFlush(toDomainObject(orderForm));
        newOrder.getOrderItemList().forEach(item->domainEventPublisher.publish(new OrderItemCreated(item.getItemId().getId())));
        return newOrder.getId();
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(OrderId id) {
        return orderRepository.findById(id);
    }

    @Override
    public void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdNotExistException::new);
        order.addItem(orderItemForm.getItem());
        orderRepository.saveAndFlush(order);
        domainEventPublisher.publish(new OrderItemCreated(orderItemForm.getItem().getId().getId()));
    }

    @Override
    public void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException, OrderItemIdNotExistException {
        Order order = orderRepository.findById(orderId).orElseThrow(OrderIdNotExistException::new);
        order.removeItem(orderItemId);
        orderRepository.saveAndFlush(order);
    }

    private Order toDomainObject(OrderForm orderForm) {
        var order = new Order(LocalDateTime.now(),orderForm.getCurrency());
        orderForm.getItems().forEach(item->order.addItem(item.getItem()));
        return order;
    }
}
