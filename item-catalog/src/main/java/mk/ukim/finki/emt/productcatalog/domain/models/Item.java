package mk.ukim.finki.emt.productcatalog.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.productcatalog.domain.models.enums.Category;
import mk.ukim.finki.emt.productcatalog.domain.models.enums.Gender;
import mk.ukim.finki.emt.productcatalog.domain.valueObjects.Size;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.time.LocalDateTime;

@Entity
@Table(name="item")
@Getter
public class Item extends AbstractEntity<ItemId> {

    Long sellerId; //should be updated to UserId sellerId
    String name;
    @Enumerated(value = EnumType.STRING)
    Category category;
    @Enumerated(value = EnumType.STRING)
    Gender gender;
    Money price;
    Size size;
    String description;
    String image;
    boolean outOfStock;

    protected Item() {
        super(ItemId.randomId(ItemId.class));
    }

    public static Item build(Long sellerId, String name, Category category,
                             Gender gender, Money price, Size size,
                             String description, String image) {
        Item i = new Item();
        i.sellerId = sellerId;
        i.name = name;
        i.category = category;
        i.gender = gender;
        i.price = price;
        i.size = size;
        i.description = description;
        i.image = image;
        i.outOfStock = false;

        return i;
    }

    public void itemOutOfStock() {
        this.outOfStock = true;
    }

    public void itemOnStock() {
        this.outOfStock = false;
    }

}
