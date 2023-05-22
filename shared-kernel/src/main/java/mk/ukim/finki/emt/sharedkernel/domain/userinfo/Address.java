package mk.ukim.finki.emt.sharedkernel.domain.userinfo;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Address implements ValueObject {

    private final String street;
    private final String postalCode;
    private final String country;

    protected Address(){
        street="";
        postalCode="";
        country="";
    }
}
