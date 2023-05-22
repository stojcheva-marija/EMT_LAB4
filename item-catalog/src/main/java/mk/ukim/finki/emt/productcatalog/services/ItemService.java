package mk.ukim.finki.emt.productcatalog.services;

import mk.ukim.finki.emt.productcatalog.domain.models.Item;
import mk.ukim.finki.emt.productcatalog.domain.models.ItemId;
import mk.ukim.finki.emt.productcatalog.services.forms.ItemForm;

import java.util.List;

public interface ItemService {

    Item findById(ItemId id);
    Item createProduct(ItemForm form);
    Item orderItemCreated(ItemId itemId);
    Item orderItemRemoved(ItemId itemId);
    List<Item> getAll();

}
