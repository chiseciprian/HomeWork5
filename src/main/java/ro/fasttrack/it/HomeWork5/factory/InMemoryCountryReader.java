package ro.fasttrack.it.HomeWork5.factory;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ro.fasttrack.it.HomeWork5.domain.Country;

import java.util.List;

@Profile("memory")
@Component
public class InMemoryCountryReader implements CountryReader {
    @Override
    public List<Country> readCountries() {
        return List.of(new Country("Romania", "Bucharest", 7000000, 1254631, "Europe,", List.of("HUN", "BUG", "SRB", "MOL", "UKR")),
                new Country("Hungary", "Budapest", 12546987, 567468877, "Europe", List.of("SRB", "UKR", "SLO", "AUS")));
    }
}
