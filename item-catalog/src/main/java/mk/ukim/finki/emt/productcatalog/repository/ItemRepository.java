package mk.ukim.finki.emt.productcatalog.repository;

import mk.ukim.finki.emt.productcatalog.domain.models.Item;
import mk.ukim.finki.emt.productcatalog.domain.models.ItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, ItemId>{

}
