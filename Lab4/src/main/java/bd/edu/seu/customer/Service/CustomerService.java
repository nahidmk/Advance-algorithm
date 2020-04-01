package bd.edu.seu.customer.Service;

import bd.edu.seu.customer.Repository.CustomerRepository;
import bd.edu.seu.customer.Repository.PhoneNumberRepsitory;
import bd.edu.seu.customer.model.Customer;
import bd.edu.seu.customer.model.CustomerPhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {


    private CustomerRepository customerRepository;
    private PhoneNumberRepsitory phoneNumberRepsitory;

    public CustomerService(CustomerRepository customerRepository, PhoneNumberRepsitory phoneNumberRepsitory) {
        this.customerRepository = customerRepository;
        this.phoneNumberRepsitory = phoneNumberRepsitory;
    }

    public void insertData()
    {
        CustomerPhoneNumber phoneNumber = new CustomerPhoneNumber(1,"+001","009","234567");
        CustomerPhoneNumber phoneNumber1 = new CustomerPhoneNumber(2,"+002","007","234565");
        CustomerPhoneNumber phoneNumber2= new CustomerPhoneNumber(3,"+003","004","234567");
        CustomerPhoneNumber phoneNumber3 = new CustomerPhoneNumber(4,"+004","008","238567");
        CustomerPhoneNumber phoneNumber4 = new CustomerPhoneNumber(5,"+005","002","230567");

        phoneNumberRepsitory.save(phoneNumber);
        phoneNumberRepsitory.save(phoneNumber1);
        phoneNumberRepsitory.save(phoneNumber2);
        phoneNumberRepsitory.save(phoneNumber3);
        phoneNumberRepsitory.save(phoneNumber4);

        List<CustomerPhoneNumber>phoneNumberList = Arrays.asList(phoneNumber,phoneNumber1);
        List<CustomerPhoneNumber>phoneNumberList1 = Arrays.asList(phoneNumber2,phoneNumber3);
        List<CustomerPhoneNumber>phoneNumberList2 = Arrays.asList(phoneNumber4);
        Customer customer = new Customer(123,"mk", LocalDate.of(2009,01,12),phoneNumberList);
        Customer customer1 = new Customer(124,"ms", LocalDate.of(2009,01,12),phoneNumberList1);
        Customer customer2 = new Customer(125,"mkl", LocalDate.of(2009,01,12),phoneNumberList2);

        customerRepository.save(customer);
        customerRepository.save(customer1);
        customerRepository.save(customer2);



    }
}
