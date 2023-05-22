package mk.ukim.finki.emt.ordermanagment.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagment.domain.valueObjects.ItemId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    @AttributeOverride(name = "id", column = @Column(name="item_id", nullable = false))
    private ItemId itemId;

    private Money itemPrice;

    public OrderItem() {
        super(DomainObjectId.randomId(OrderItemId.class));
    }

    public OrderItem(@NonNull ItemId itemId, @NonNull Money itemPrice) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.itemId = itemId;
        this.itemPrice = itemPrice;
    }

}
