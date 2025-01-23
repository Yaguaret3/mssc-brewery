package guru.microservices.mssc_brewery.service.v1.impl;

import guru.microservices.mssc_brewery.service.v1.BeerService;
import guru.microservices.mssc_brewery.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDTO createNewBeer(BeerDTO beerDTO) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTO beerDTO) {
        log.debug("Updating beer {} with name {} and style {}", beerId, beerDTO.getBeerName(), beerDTO.getBeerStyle());
    }

    @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Deleting beer {}", beerId.toString());
    }
}
