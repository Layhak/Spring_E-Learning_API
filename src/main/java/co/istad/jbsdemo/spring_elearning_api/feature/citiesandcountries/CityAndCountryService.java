package co.istad.jbsdemo.spring_elearning_api.feature.citiesandcountries;

import co.istad.jbsdemo.spring_elearning_api.domain.City;
import co.istad.jbsdemo.spring_elearning_api.domain.Country;
import co.istad.jbsdemo.spring_elearning_api.feature.citiesandcountries.dto.CityResponse;

import java.util.List;

public interface CityAndCountryService {
    List<CityResponse> getAllCities();
    List<Country> getAllCountries();
    List<CityResponse> getCitiesByCountry(String iso);
}