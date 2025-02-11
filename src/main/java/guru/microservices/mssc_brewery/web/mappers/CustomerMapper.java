package guru.microservices.mssc_brewery.web.mappers;

import guru.microservices.mssc_brewery.domain.Customer;
import guru.microservices.mssc_brewery.web.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {

    Customer customerDtoToEntity(CustomerDTO dto);
    CustomerDTO customerToDTO(Customer entity);
}
