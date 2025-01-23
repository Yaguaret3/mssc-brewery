package guru.microservices.mssc_brewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.microservices.mssc_brewery.service.v1.CustomerService;
import guru.microservices.mssc_brewery.web.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @MockitoBean
    CustomerService customerService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void createNewCustomer() throws Exception {

        CustomerDTO customerDTO = CustomerDTO.builder()
                .name("Zi")
                .build();
        String jsonCustomerDTO = objectMapper.writeValueAsString(customerDTO);

        mockMvc.perform(post("/api/v1/customer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonCustomerDTO))
                .andExpect(status().isBadRequest());
    }
}