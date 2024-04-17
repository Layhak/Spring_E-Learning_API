package co.istad.jbsdemo.spring_elearning_api.feature.city;

import co.istad.jbsdemo.spring_elearning_api.domain.City;
import co.istad.jbsdemo.spring_elearning_api.feature.city.dto.CityResponse;
import co.istad.jbsdemo.spring_elearning_api.utilities.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/cities")
    public BaseResponse<List<CityResponse>> getAllCities() {
        List<City> cities = cityService.getAllCitiesSortedByName();
        List<CityResponse> cityResponses = cities.stream()
                .map(city -> new CityResponse(city.getId(), city.getName(), Math.toIntExact(city.getCountry().getId())))
                .collect(Collectors.toList());
        return BaseResponse.<List<CityResponse>>ok().setPayload(cityResponses);
    }

    @GetMapping("/countries/{iso}/cities")
    public BaseResponse<List<CityResponse>> getCitiesByCountryIso(@PathVariable String iso) {
        List<City> cities = cityService.getCitiesByCountryIso(iso);
        List<CityResponse> cityResponses = cities.stream()
                .map(city -> new CityResponse(city.getId(), city.getName(), Math.toIntExact(city.getCountry().getId())))
                .collect(Collectors.toList());
        return BaseResponse.<List<CityResponse>>ok().setPayload(cityResponses);
    }
}