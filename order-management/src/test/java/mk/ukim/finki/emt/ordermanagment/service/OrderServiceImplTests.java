package mk.ukim.finki.emt.ordermanagment.service;

import mk.ukim.finki.emt.ordermanagment.domain.valueObjects.Item;
import mk.ukim.finki.emt.ordermanagment.domain.valueObjects.ItemId;
import mk.ukim.finki.emt.ordermanagment.service.forms.OrderItemForm;
import mk.ukim.finki.emt.ordermanagment.xport.client.ItemClient;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderServiceImplTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ItemClient itemClient;

    private static Item newItem(String name, Money price) {
        Item i = new Item(ItemId.randomId(ItemId.class), name, price);
        return i;
    }

    @Test
    public void testPlaceOrderWithRealData() {
        List<Item> itemList = itemClient.findAll();
    }
}
