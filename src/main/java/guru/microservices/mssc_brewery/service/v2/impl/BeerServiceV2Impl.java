package guru.microservices.mssc_brewery.service.v2.impl;

import guru.microservices.mssc_brewery.service.v2.BeerServiceV2;
import guru.microservices.mssc_brewery.web.model.BeerDTO;
import guru.microservices.mssc_brewery.web.model.v2.BeerDTOV2;
import guru.microservices.mssc_brewery.web.model.v2.BeerStyleEnum;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
    @Override
    public BeerDTOV2 getBeerById(UUID beerId) {
        return BeerDTOV2.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleEnum.ALE)
                .build();
    }

    @Override
    public BeerDTOV2 createNewBeer(BeerDTOV2 beerDTO) {
        return null;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTOV2 beerDTO) {

    }

    @Override
    public void deleteBeer(UUID beerId) {

    }
}
