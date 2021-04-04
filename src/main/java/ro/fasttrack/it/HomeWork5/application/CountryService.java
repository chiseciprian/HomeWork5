package ro.fasttrack.it.HomeWork5.application;

import org.springframework.stereotype.Service;
import ro.fasttrack.it.HomeWork5.domain.Country;
import ro.fasttrack.it.HomeWork5.exception.rest.CountryNotFoundException;
import ro.fasttrack.it.HomeWork5.factory.FileCountryReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CountryService {
    private final List<Country> countries;

    public CountryService() {
        this.countries = new FileCountryReader().readCountries();
    }

    public List<Country> getAllCountries() {
        return new ArrayList<>(countries);
    }

    public List<String> getCountriesNames() {
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }

    public String getCountryCapital(String countryId) {
        return countries.stream()
                .filter(country -> country.getUuid().toString().equals(countryId))
                .map(Country::getCapital)
                .findFirst()
                .orElseThrow(CountryNotFoundException::new);
    }

    public long getCountryPopulation(String countryId) {
        return countries.stream()
                .filter(country -> country.getUuid().toString().equals(countryId))
                .map(Country::getPopulation)
                .findFirst()
                .orElseThrow(CountryNotFoundException::new);
    }

    public List<Country> getCountriesByContinent(String continent) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(continent))
                .collect(Collectors.toList());
    }

    public List<String> getCountryNeighbours(String countryId) {
        return countries.stream()
                .filter(country -> country.getUuid().toString().equals(countryId))
                .map(Country::getNeighbours)
                .findFirst()
                .orElseThrow(CountryNotFoundException::new);
    }

    public List<Country> getCountryByContinentWithPopulation(String continent, long population) {
        return countries.stream()
                .filter(country -> country.getContinent().equals(continent))
                .filter(country -> country.getPopulation() >= population)
                .collect(Collectors.toList());
    }

    public List<Country> getCountryByNeighboursFiltering(String includeNeighbor, String excludeNeighbor) {
        return countries.stream()
                .filter(country -> country.getNeighbours().contains(includeNeighbor))
                .filter(country -> !country.getNeighbours().contains(excludeNeighbor))
                .collect(Collectors.toList());
    }

    public Map<String, Long> getMapOfCountryAndPopulation() {
        return countries.stream()
                .collect(Collectors.toMap(Country::getName, Country::getPopulation));
    }

    public Map<String, List<Country>> getCountriesGroupingByContinent() {
        return countries.stream()
                .collect(Collectors.groupingBy(Country::getContinent));
    }
}
