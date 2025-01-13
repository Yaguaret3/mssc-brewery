package guru.microservices.mssc_brewery.web.controller;

import guru.microservices.mssc_brewery.service.v1.CustomerService;
import guru.microservices.mssc_brewery.web.model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> createNewCustomer(@RequestBody CustomerDTO customerDTO){
        CustomerDTO customerCreated = customerService.createNewCustomer(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", String.format("/api/v1/customer/%s", customerCreated.getId().toString()));
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerDTO customerDTO){
        customerService.updateCustomer(customerId, customerDTO);
    }
    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID customerId){
        customerService.deleteCustomer(customerId);
    }
}
