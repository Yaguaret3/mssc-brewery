package guru.microservices.mssc_brewery.service.v1.impl;

import guru.microservices.mssc_brewery.service.v1.CustomerService;
import guru.microservices.mssc_brewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDTO getCustomerById(UUID id) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Guru")
                .build();
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("New Guru")
                .build();
    }

    @Override
    public void updateCustomer(UUID customerId, CustomerDTO customerDTO) {
        log.debug("Updating Customer {} with name {}", customerId, customerDTO.getName());
    }

    @Override
    public void deleteCustomer(UUID customerId) {
        log.debug("Deleting Customer {}", customerId);
    }
}
