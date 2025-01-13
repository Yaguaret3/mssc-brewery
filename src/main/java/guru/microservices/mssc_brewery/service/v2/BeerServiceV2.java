package guru.microservices.mssc_brewery.service.v2;

import guru.microservices.mssc_brewery.web.model.v2.BeerDTOV2;

import java.util.UUID;

public interface BeerServiceV2 {

    BeerDTOV2 getBeerById(UUID beerId);

    BeerDTOV2 createNewBeer(BeerDTOV2 beerDTO);

    void updateBeer(UUID beerId, BeerDTOV2 beerDTO);

    void deleteBeer(UUID beerId);
}
