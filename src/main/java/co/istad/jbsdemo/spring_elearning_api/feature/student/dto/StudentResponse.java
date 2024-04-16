package co.istad.jbsdemo.spring_elearning_api.feature.student.dto;

import lombok.Builder;
import org.mapstruct.ap.internal.model.source.builtin.LocalDateTimeToXmlGregorianCalendar;

@Builder
public record StudentResponse(
        Long id,
        String highSchool,
        String university,
        Boolean isBlocked,
        Long userId
        ) {

}
