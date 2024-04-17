package co.istad.jbsdemo.spring_elearning_api.feature.city.dto;

public record CityResponse(
    Long id,
    String name,
    Integer countryId
) {
}
