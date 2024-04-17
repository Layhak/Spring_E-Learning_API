package co.istad.jbsdemo.spring_elearning_api.feature.citiesandcountries;

import co.istad.jbsdemo.spring_elearning_api.domain.City;
import co.istad.jbsdemo.spring_elearning_api.domain.Country;
import co.istad.jbsdemo.spring_elearning_api.feature.citiesandcountries.dto.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CityAndCountryController {

    private final CityAndCountryService cityAndCountryService;


    @GetMapping("/cities")
    public List<CityResponse> getAllCities() {
        return cityAndCountryService.getAllCities();
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return cityAndCountryService.getAllCountries();
    }

    @GetMapping("/countries/{iso}/cities")
    public List<CityResponse> getCitiesByCountry(@PathVariable String iso) {
        return cityAndCountryService.getCitiesByCountry(iso);
    }
}