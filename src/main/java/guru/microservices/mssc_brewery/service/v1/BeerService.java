package guru.microservices.mssc_brewery.service.v1;

import guru.microservices.mssc_brewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO createNewBeer(BeerDTO beerDTO);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deleteBeer(UUID beerId);
}
