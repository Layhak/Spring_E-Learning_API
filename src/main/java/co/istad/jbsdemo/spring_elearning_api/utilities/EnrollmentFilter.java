package co.istad.jbsdemo.spring_elearning_api.utilities;

import lombok.Data;

@Data
public class EnrollmentFilter {
    private String code;
    private String title;
    private Integer isCertified;

}
