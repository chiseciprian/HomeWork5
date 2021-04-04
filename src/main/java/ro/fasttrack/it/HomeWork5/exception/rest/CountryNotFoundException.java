package ro.fasttrack.it.HomeWork5.exception.rest;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException() {
        super("Country Not Found");
    }
}
