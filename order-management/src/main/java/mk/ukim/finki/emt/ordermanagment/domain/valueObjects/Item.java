package mk.ukim.finki.emt.ordermanagment.domain.valueObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class Item implements ValueObject {

    private final ItemId id;
    private final String name;
    private final Money price;

    protected Item(){
        id = ItemId.randomId(ItemId.class);
        name = "";
        price = Money.valueOf(Currency.MKD, 0);
    }

    @JsonCreator
    public Item(@JsonProperty("id") ItemId id,
                @JsonProperty("name") String name,
                @JsonProperty("price") Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
