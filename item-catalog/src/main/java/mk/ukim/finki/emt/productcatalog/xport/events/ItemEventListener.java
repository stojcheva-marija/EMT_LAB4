package mk.ukim.finki.emt.productcatalog.xport.events;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.productcatalog.domain.models.ItemId;
import mk.ukim.finki.emt.productcatalog.services.ItemService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemRemoved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemEventListener {


    private final ItemService itemService;

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "itemCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage, OrderItemCreated.class);
            itemService.orderItemCreated(ItemId.of(event.getItemId()));
        } catch (Exception e){

        }

    }

    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_REMOVED, groupId = "itemCatalog")
    public void consumeOrderItemRemovedEvent(String jsonMessage) {
        try {
            OrderItemRemoved event = DomainEvent.fromJson(jsonMessage, OrderItemRemoved.class);
            itemService.orderItemRemoved(ItemId.of(event.getItemId()));
        } catch (Exception e) {
        }
    }


    }
