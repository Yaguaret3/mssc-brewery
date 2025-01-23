package guru.microservices.mssc_brewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.microservices.mssc_brewery.service.v1.BeerService;
import guru.microservices.mssc_brewery.web.model.BeerDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @MockitoBean
    BeerService beerService;
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    public BeerDTO validBeer;

    @BeforeEach
    public void setUp(){
        validBeer = BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName("Beer1")
                .beerStyle("PALE_ALE")
                .upc(12345678912L)
                .build();
    }

    @Test
    void getBeerById() throws Exception {
        given(beerService.getBeerById(any(UUID.class)))
                .willReturn(validBeer);

        mockMvc.perform(get("/api/v1/beer/"+UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", Matchers.is(validBeer.getId().toString())))
                .andExpect(jsonPath("$.beerName", Matchers.is("Beer1")));
    }

    @Test
    void createBeer() throws Exception {
        BeerDTO beerDTO = validBeer;
        beerDTO.setId(null);
        BeerDTO savedDto = BeerDTO.builder().id(UUID.randomUUID()).beerName("New Beer").build();
        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

        given(beerService.createNewBeer(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeer() throws Exception {
        BeerDTO beerDTO = validBeer;
        beerDTO.setId(null);
        String beerDtoJson = objectMapper.writeValueAsString(beerDTO);

        mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isNoContent());

        then(beerService).should().updateBeer(any(), any());
    }

    @Test
    void deleteBeer() {
    }
}