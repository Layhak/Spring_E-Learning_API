package co.istad.jbsdemo.spring_elearning_api.feature.city;

import co.istad.jbsdemo.spring_elearning_api.domain.City;

import java.util.List;

public interface CityService {
    List<City> getAllCitiesSortedByName();
    List<City> getCitiesByCountryIso(String iso);
}