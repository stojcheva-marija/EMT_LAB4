package mk.ukim.finki.emt.ordermanagment.service.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.ordermanagment.domain.valueObjects.Item;

@Data
public class OrderItemForm {

    @NotNull
    private Item item;
}

