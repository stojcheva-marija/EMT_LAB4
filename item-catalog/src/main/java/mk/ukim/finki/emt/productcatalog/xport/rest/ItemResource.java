package mk.ukim.finki.emt.productcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.models.Item;
import mk.ukim.finki.emt.productcatalog.services.ItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@AllArgsConstructor
public class ItemResource {

    private final ItemService itemService;

    @GetMapping
    public List<Item> getAll() {
        return itemService.getAll();
    }

}
