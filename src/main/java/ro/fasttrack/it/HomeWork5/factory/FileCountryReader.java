package ro.fasttrack.it.HomeWork5.factory;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ro.fasttrack.it.HomeWork5.domain.Country;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Profile("file")
@Component
public class FileCountryReader implements CountryReader {
    private final String sourceFile;

    public FileCountryReader() {
        this.sourceFile = "src/main/resources/countries.txt";
    }

    public List<Country> readCountries() {
        try {
            return Files.lines(Path.of(sourceFile))
                    .map(this::readCountry)
                    .collect(toList());
        } catch (IOException e) {
            System.err.println("Could not read from file " + sourceFile);
        }
        return List.of();
    }

    private Country readCountry(String line) {
        String[] countryInfo = line.split("\\|");
        return new Country(
                countryInfo[0],
                countryInfo[1],
                Long.parseLong(countryInfo[2]),
                Long.parseLong(countryInfo[3]),
                countryInfo[4],
                countryInfo.length > 5 ? parseNeighbours(countryInfo[5]) : List.of()
        );
    }

    private List<String> parseNeighbours(String neighbours) {
        if (neighbours != null) {
            return Arrays.stream(neighbours.split("~"))
                    .collect(toList());
        } else {
            return List.of();
        }
    }
}

