package mk.ukim.finki.emt.ordermanagment.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class OrderId extends DomainObjectId {

    protected OrderId(@NonNull String uuid) {
        super(uuid);
    }
}
