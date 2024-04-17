package co.istad.jbsdemo.spring_elearning_api.feature.citiesandcountries;

import co.istad.jbsdemo.spring_elearning_api.domain.City;
import co.istad.jbsdemo.spring_elearning_api.domain.Country;
import co.istad.jbsdemo.spring_elearning_api.feature.citiesandcountries.dto.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityAndCountryServiceImpl implements CityAndCountryService {

    private final CityAndCountryRepository cityAndCountryRepository;



    @Override
    public List<CityResponse> getAllCities() {
        //get all cities
        List<City> cities = cityAndCountryRepository.findAllCities();

        return cities.stream()
                .map(city -> new CityResponse(city.getId(), city.getName(), city.getCountry().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Country> getAllCountries() {
        //get all countries
        return cityAndCountryRepository.findAllCountries();
    }

@Override
public List<CityResponse> getCitiesByCountry(String iso) {
    // Convert iso to uppercase
    String isoUpperCase = iso.toUpperCase();

    List<City> cities = cityAndCountryRepository.findCitiesByCountry(isoUpperCase);

    return cities.stream()
                 .map(city -> new CityResponse(city.getId(), city.getName(), city.getCountry().getId()))
                 .collect(Collectors.toList());
}
}