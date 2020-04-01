package bd.edu.seu.customer;

import bd.edu.seu.customer.Service.CustomerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CustomerApplication.class, args);
        CustomerService bean = run.getBean(CustomerService.class);
        bean.insertData();
    }

}
