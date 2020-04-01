package bd.edu.seu.customer.Repository;

import bd.edu.seu.customer.model.CustomerPhoneNumber;
import org.springframework.data.repository.CrudRepository;

public interface PhoneNumberRepsitory extends CrudRepository<CustomerPhoneNumber,Integer> {
}
