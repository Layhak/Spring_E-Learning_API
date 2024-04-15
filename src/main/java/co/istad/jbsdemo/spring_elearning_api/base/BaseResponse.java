package co.istad.jbsdemo.spring_elearning_api.base;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Data
@Accessors(chain = true)
public class BaseResponse<T> {

    private T payload;
    private String message;
    private Object metadata;
    private int status;

    public static <T> BaseResponse<T> createSuccess() {
        return new BaseResponse<T>()
            .setStatus(HttpStatus.CREATED.value())
            .setMessage("Created Successfully!!! ");
    }

    public static <T> BaseResponse<T> ok() {
        return new BaseResponse<T>()
            .setStatus(HttpStatus.OK.value())
            .setMessage("Successfully Retrieved the data !!! ");
    }

    public static <T> BaseResponse<T> notFound() {
        return new BaseResponse<T>()
            .setStatus(HttpStatus.NOT_FOUND.value())
            .setMessage("Items could not be found!! ");
    }

    public static <T> BaseResponse<T> badRequest() {
        return new BaseResponse<T>()
            .setStatus(HttpStatus.BAD_REQUEST.value())
            .setMessage("Bad request provided !");
    }

    public static <T> BaseResponse<T> updateSuccess() {
        return new BaseResponse<T>()
            .setStatus(HttpStatus.OK.value())
            .setMessage("Successfully update the entry!");
    }

    public static <T> BaseResponse<T> deleteSuccess() {
        return new BaseResponse<T>()
            .setStatus(HttpStatus.OK.value())
            .setMessage("Content has been deleted!");
    }

}