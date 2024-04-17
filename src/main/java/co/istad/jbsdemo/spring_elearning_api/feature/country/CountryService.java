package co.istad.jbsdemo.spring_elearning_api.feature.country;

import co.istad.jbsdemo.spring_elearning_api.domain.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountriesSortedByName();
}
