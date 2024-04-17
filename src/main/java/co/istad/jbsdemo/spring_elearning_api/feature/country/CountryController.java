package co.istad.jbsdemo.spring_elearning_api.feature.country;

import co.istad.jbsdemo.spring_elearning_api.domain.Country;
import co.istad.jbsdemo.spring_elearning_api.feature.country.dto.CountryResponse;
import co.istad.jbsdemo.spring_elearning_api.utilities.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;
    @GetMapping("/countries")
    public BaseResponse<List<CountryResponse>> getAllCountries() {
        List<Country> countries = countryService.getAllCountriesSortedByName();
        List<CountryResponse> countryResponses = countries.stream()
                .map(country -> new CountryResponse(country.getId(), country.getFlag(), country.getIso(), country.getName(), country.getNiceName(), country.getNumCode(), country.getPhoneCode()))
                .collect(Collectors.toList());
        return BaseResponse.<List<CountryResponse>>ok().setPayload(countryResponses);
    }
}