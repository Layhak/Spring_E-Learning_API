package co.istad.jbsdemo.spring_elearning_api.feature.citiesandcountries.dto;

public record CityResponse(
        long id,
        String name,
        long countryId
) {
}
