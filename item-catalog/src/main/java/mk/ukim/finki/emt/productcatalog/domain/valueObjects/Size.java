package mk.ukim.finki.emt.productcatalog.domain.valueObjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Embeddable
@Getter
public class Size implements ValueObject {
    private final String size;
    private final String fitDescription;

    protected Size(){
        size = "";
        fitDescription = "";
    }

    public Size(@NonNull String size, String fitDescription){
        this.size = size;
        this.fitDescription = fitDescription;
    }

    public static Size valueOf(String size, String fitDescription) {

        return new Size(size, fitDescription);
    }
}
