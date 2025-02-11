package guru.microservices.mssc_brewery.mappers;

import guru.microservices.mssc_brewery.domain.Beer;
import guru.microservices.mssc_brewery.web.model.v2.BeerDTOV2;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    BeerDTOV2 beerToDTOv2(Beer beer);
    Beer DTOv2ToBeer(BeerDTOV2 dto);
}
