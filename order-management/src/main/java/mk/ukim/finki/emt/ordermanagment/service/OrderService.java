package mk.ukim.finki.emt.ordermanagment.service;

import mk.ukim.finki.emt.ordermanagment.domain.exceptions.OrderIdNotExistException;
import mk.ukim.finki.emt.ordermanagment.domain.exceptions.OrderItemIdNotExistException;
import mk.ukim.finki.emt.ordermanagment.domain.model.Order;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagment.domain.model.OrderItemId;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderForm;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderId placeOrder(OrderForm orderForm);

    List<Order> findAll();

    Optional<Order> findById(OrderId id);

    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdNotExistException;

    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdNotExistException, OrderItemIdNotExistException;
}

