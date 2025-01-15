package guru.microservices.mssc_brewery.web.controller;

import guru.microservices.mssc_brewery.service.v1.BeerService;
import guru.microservices.mssc_brewery.web.model.BeerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
@Deprecated
public class BeerController {

    private final BeerService beerService;

    BeerController(BeerService beerService){
        this.beerService = beerService;
    }
    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Void> createBeer(@RequestBody BeerDTO beerDTO){
        BeerDTO beerCreated = beerService.createNewBeer(beerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", String.format("/api/v1/beer/%s", beerCreated.getId().toString())); //todo add hostname to url

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity<Void> updateBeer(@PathVariable UUID beerId, @RequestBody BeerDTO beerDTO){
        beerService.updateBeer(beerId, beerDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId){
        beerService.deleteBeer(beerId);
    }
}
