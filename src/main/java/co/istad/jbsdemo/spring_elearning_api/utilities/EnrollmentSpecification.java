package co.istad.jbsdemo.spring_elearning_api.utilities;

import co.istad.jbsdemo.spring_elearning_api.domain.Enrollment;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
public class EnrollmentSpecification implements Specification<Enrollment> {
    private final EnrollmentFilter enrollmentFilter;
    List<Predicate> predicates = new ArrayList<>();
    @Override
    public Predicate toPredicate(Root<Enrollment> enroll, CriteriaQuery<?> query, CriteriaBuilder criteria) {

        if(enrollmentFilter.getCode() != null){
            Predicate code = criteria.like(criteria.upper(enroll.get("code")), "%" + enrollmentFilter.getCode().toUpperCase() + "%");
            predicates.add(code);
        }

        if(enrollmentFilter.getTitle() != null) {
            Predicate title = enroll.get("title").in(enrollmentFilter.getTitle());
            predicates.add(title);
        }

        if(enrollmentFilter.getIsCertified() != null) {
            Predicate isCertified = enroll.get("isCertified").in(enrollmentFilter.getIsCertified());
            predicates.add(isCertified);
        }

        //return cb.and(predicates.toArray(new Predicate[0]));
        return criteria.and(predicates.toArray(Predicate[]::new));
    }
}
