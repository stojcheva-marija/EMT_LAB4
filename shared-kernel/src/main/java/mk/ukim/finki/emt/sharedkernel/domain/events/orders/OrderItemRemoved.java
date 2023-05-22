package mk.ukim.finki.emt.sharedkernel.domain.events.orders;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;

@Getter
public class OrderItemRemoved extends DomainEvent {

    private String itemId;

    public OrderItemRemoved(String topic) {
        super(topic);
    }

    public OrderItemRemoved(String topic, String itemId) {
        super(topic);
        this.itemId = itemId;
    }
}
