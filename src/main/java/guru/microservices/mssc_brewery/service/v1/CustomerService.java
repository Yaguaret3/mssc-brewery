package guru.microservices.mssc_brewery.service.v1;

import guru.microservices.mssc_brewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO getCustomerById(UUID id);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    void updateCustomer(UUID customerId, CustomerDTO customerDTO);

    void deleteCustomer(UUID customerId);
}
