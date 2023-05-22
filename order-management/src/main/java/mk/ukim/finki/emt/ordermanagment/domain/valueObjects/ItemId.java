package mk.ukim.finki.emt.ordermanagment.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

@Embeddable
public class ItemId extends DomainObjectId {

    protected ItemId() {
        super(ItemId.randomId(ItemId.class).getId());
    }

    public ItemId(String uuid) {
        super(uuid);
    }
}
