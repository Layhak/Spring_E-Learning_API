package co.istad.jbsdemo.spring_elearning_api.utilities;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface EnrollmentPagination {
    int DEFAULT_PAGE_LIMIT = 5;
    int DEFAULT_PAGE_NUMBER = 1;
    String PAGE_LIMIT = "_limit";
    String PAGE_NUMBER = "_page";

    static Pageable getPageable(int pageNumber, int pageSize) {
        if (pageNumber < DEFAULT_PAGE_NUMBER) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_LIMIT;
        }
        return PageRequest.of(pageNumber - 1, pageSize);
    }
}
