package mk.ukim.finki.emt.ordermanagment;

import jakarta.validation.Validator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;



@SpringBootApplication
public class OrderManagmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderManagmentApplication.class, args);
    }

    @Bean
    public Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
}
