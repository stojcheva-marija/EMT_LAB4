package mk.ukim.finki.emt.productcatalog.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.models.Item;
import mk.ukim.finki.emt.productcatalog.domain.models.enums.Category;
import mk.ukim.finki.emt.productcatalog.domain.models.enums.Gender;
import mk.ukim.finki.emt.productcatalog.domain.valueObjects.Size;
import mk.ukim.finki.emt.productcatalog.repository.ItemRepository;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {


    private final ItemRepository itemRepository;

    @PostConstruct
    public void initData() {
        Item i1 = Item.build(1L, "ZARA DRESS", Category.DRESS, Gender.FEMALE,
                Money.valueOf(Currency.MKD, 500), Size.valueOf("S","Mini dress"),
                "summer dress with flowers", "some_image");

        Item i2 = Item.build(2L, "MANGO SKIRT", Category.SKIRT, Gender.FEMALE,
                Money.valueOf(Currency.MKD, 400), Size.valueOf("M","Midi skirt"),
                "Worn only once", "some_image");

        if (itemRepository.findAll().isEmpty()) {
            itemRepository.saveAll(Arrays.asList(i1,i2));
        }
    }

}
