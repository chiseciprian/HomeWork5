package ro.fasttrack.it.HomeWork5.domain;

import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Country {
    private final UUID uuid;
    private final String name;
    private final String capital;
    private final long population;
    private final long area;
    private final String continent;
    private final List<String> neighbours;

    public Country(String name, String capital, long population, long area, String continent, List<String> neighbours) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbours = neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return population == country.population && area == country.area && Objects.equals(uuid, country.uuid) && Objects.equals(name, country.name) && Objects.equals(capital, country.capital) && Objects.equals(continent, country.continent) && Objects.equals(neighbours, country.neighbours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, capital, population, area, continent, neighbours);
    }

    @Override
    public String toString() {
        return "Country{" +
               "uuid=" + uuid +
               ", name='" + name + '\'' +
               ", capital='" + capital + '\'' +
               ", population=" + population +
               ", area=" + area +
               ", continent='" + continent + '\'' +
               ", neighbours=" + neighbours +
               '}';
    }
}
