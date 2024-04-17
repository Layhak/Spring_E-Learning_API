package co.istad.jbsdemo.spring_elearning_api.feature.country.dto;

public record CountryResponse(
        long id,
        String flag,
        String iso,
        String name,
        String niceName,
        Integer numCode,
        Integer phoneCode
) {
}
