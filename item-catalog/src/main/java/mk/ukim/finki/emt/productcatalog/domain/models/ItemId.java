package mk.ukim.finki.emt.productcatalog.domain.models;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class ItemId extends DomainObjectId{

    private ItemId(){
        super(ItemId.randomId(ItemId.class).getId());
    }

    public ItemId(@NonNull String uuid){
        super(uuid);
    }

    public static ItemId of(String uuid){
        ItemId i = new ItemId(uuid);
        return i;
    }
}
