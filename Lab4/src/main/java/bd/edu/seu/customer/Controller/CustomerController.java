package bd.edu.seu.customer.Controller;

import bd.edu.seu.customer.Repository.CustomerRepository;
import bd.edu.seu.customer.Service.CustomerService;
import bd.edu.seu.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable long id)
    {
        return customerRepository.findById(id).get();
    }

    @GetMapping("")
    public List<Customer> getCustomers()
    {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }
}
