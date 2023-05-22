package mk.ukim.finki.emt.usermanagment.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.ukim.finki.emt.sharedkernel.domain.userinfo.Address;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name = "users")
public class User extends AbstractEntity<UserId> {
    String firstName;
    String latName;
    String email;
    String password;
    String phoneNumber;
    Address address;

    protected User() {
        super(UserId.randomId(UserId.class));
    }
}
