package mk.ukim.finki.emt.ordermanagment.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class OrderItemId extends DomainObjectId {

    protected OrderItemId(@NonNull String uuid) {
        super(uuid);
    }
}
