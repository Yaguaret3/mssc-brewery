package guru.microservices.mssc_brewery.web.controller.v2;

import guru.microservices.mssc_brewery.service.v2.BeerServiceV2;
import guru.microservices.mssc_brewery.web.model.v2.BeerDTOV2;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/beer")
public class BeerControllerV2 {

    private final BeerServiceV2 beerServicev2;

    BeerControllerV2(BeerServiceV2 beerServicev2){
        this.beerServicev2 = beerServicev2;
    }
    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTOV2> getBeerById(@PathVariable UUID beerId){
        return new ResponseEntity<>(beerServicev2.getBeerById(beerId), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> createBeer(@Valid @RequestBody BeerDTOV2 beerDTO){
        BeerDTOV2 beerCreated = beerServicev2.createNewBeer(beerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", String.format("/api/v1/beer/%s", beerCreated.getId().toString())); //todo add hostname to url

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<Void> updateBeer(@PathVariable UUID beerId, @Valid @RequestBody BeerDTOV2 beerDTO){
        beerServicev2.updateBeer(beerId, beerDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId){
        beerServicev2.deleteBeer(beerId);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e){
        return new ResponseEntity<>(e.getConstraintViolations().stream()
                .map(c -> c.getPropertyPath() + " : " + c.getMessage())
                .toList(),
                HttpStatus.BAD_REQUEST);
    }
}
