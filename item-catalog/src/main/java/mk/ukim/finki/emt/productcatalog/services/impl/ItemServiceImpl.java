package mk.ukim.finki.emt.productcatalog.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.models.Item;
import mk.ukim.finki.emt.productcatalog.domain.models.ItemId;
import mk.ukim.finki.emt.productcatalog.domain.models.exceptions.ItemNotFoundException;
import mk.ukim.finki.emt.productcatalog.repository.ItemRepository;
import mk.ukim.finki.emt.productcatalog.services.ItemService;
import mk.ukim.finki.emt.productcatalog.services.forms.ItemForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {

    ItemRepository itemRepository;

    @Override
    public Item findById(ItemId id) {
        return itemRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public Item createProduct(ItemForm form) {
        Item i = Item.build(form.getSellerId(), form.getName(), form.getCategory(),
                form.getGender(), form.getPrice(), form.getSize(),
                form.getDescription(), form.getImage());
        itemRepository.save(i);
        return i;
    }

    @Override
    public Item orderItemCreated(ItemId itemId) {
        Item i = this.findById(itemId);
        i.itemOutOfStock();
        itemRepository.saveAndFlush(i);
        return i;
    }

    @Override
    public Item orderItemRemoved(ItemId itemId) {
        Item i = this.findById(itemId);
        i.itemOnStock();
        itemRepository.saveAndFlush(i);
        return i;
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.findAll();
    }
}
