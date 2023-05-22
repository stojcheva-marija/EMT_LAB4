package mk.ukim.finki.emt.productcatalog.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.productcatalog.domain.models.enums.Category;
import mk.ukim.finki.emt.productcatalog.domain.models.enums.Gender;
import mk.ukim.finki.emt.productcatalog.domain.valueObjects.Size;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class ItemForm {

    Long sellerId; //TODO should be updated to UserId sellerId
    String name;
    Category category;
    Gender gender;
    Money price;
    Size size;
    String description;
    String image;
}
