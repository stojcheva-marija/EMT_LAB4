package mk.ukim.finki.emt.ordermanagment.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagment.domain.model.enums.DeliveryType;
import mk.ukim.finki.emt.ordermanagment.domain.model.enums.OrderStatus;
import mk.ukim.finki.emt.ordermanagment.domain.valueObjects.Item;
import mk.ukim.finki.emt.sharedkernel.domain.userinfo.Address;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private String userId;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private LocalDateTime date;

    @Enumerated(value = EnumType.STRING)
    private DeliveryType deliveryType;

    private Address shippingAddress;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList;

    protected Order() {
        super(OrderId.randomId(OrderId.class));
    }

    public Order(LocalDateTime date, Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.date = date;
        this.currency = currency;
    }

    public Money total() {
        return orderItemList.stream()
                .map(OrderItem::getItemPrice).
                reduce(new Money(currency, 0), Money::add);
    }

    public OrderItem addItem(@NonNull Item item) {
        Objects.requireNonNull(item,"item must not be null");
        var orderItem  = new OrderItem(item.getId(),item.getPrice());
        orderItemList.add(orderItem);
        return orderItem;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderItemList.removeIf(v->v.getId().equals(orderItemId));
    }

}
