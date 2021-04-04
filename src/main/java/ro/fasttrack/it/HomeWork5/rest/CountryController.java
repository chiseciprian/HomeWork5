package ro.fasttrack.it.HomeWork5.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrack.it.HomeWork5.application.CountryService;
import ro.fasttrack.it.HomeWork5.domain.Country;

import java.util.List;
import java.util.Map;

@RestController
public class CountryController {
    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(path = "/countries")
    List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping(path = "/countries/names")
    List<String> getCountriesName() {
        return countryService.getCountriesNames();
    }

    @GetMapping(path = "/countries/{countryId}/capital")
    String getCountryCapital(@PathVariable String countryId) {
        return countryService.getCountryCapital(countryId);
    }

    @GetMapping(path = "/countries/{countryId}/population")
    long getCountryPopulation(@PathVariable String countryId) {
        return countryService.getCountryPopulation(countryId);
    }

    @GetMapping(path = "/countries/{countryId}/neighbours")
    List<String> getCountryNeighbours(@PathVariable String countryId) {
        return countryService.getCountryNeighbours(countryId);
    }

    @GetMapping(path = "/continents/{continentName}")
    List<Country> getCountryByContinentWithPopulation(@PathVariable String continentName, @RequestParam long minPopulation) {
        return countryService.getCountryByContinentWithPopulation(continentName, minPopulation);
    }

    @GetMapping(path = "/countries/neighbours")
    List<Country> getCountryByNeighboursFiltering(@RequestParam String includeNeighbor, @RequestParam String excludeNeighbor) {
        return countryService.getCountryByNeighboursFiltering(includeNeighbor, excludeNeighbor);
    }

    @GetMapping(path = "/countries/population")
    Map<String, Long> getMapOfCountryAndPopulation() {
        return countryService.getMapOfCountryAndPopulation();
    }

    @GetMapping(path = "/continents/countries")
    Map<String, List<Country>> getCountriesGroupingByContinent() {
        return countryService.getCountriesGroupingByContinent();
    }
}
