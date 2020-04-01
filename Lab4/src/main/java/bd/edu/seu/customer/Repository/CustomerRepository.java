package bd.edu.seu.customer.Repository;

import bd.edu.seu.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
