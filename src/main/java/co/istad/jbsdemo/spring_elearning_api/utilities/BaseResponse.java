package co.istad.jbsdemo.spring_elearning_api.utilities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Accessors(chain = true)
@Data
public class BaseResponse<T> {
    private T payload;
    private String message;
    private Object metadata;//? relate to pagination
    private int status;
    public  static  <T> BaseResponse<T>  createSuccess(){
        return  new BaseResponse<T>()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Success");
    }
    public  static  <T> BaseResponse<T> ok(){
        return  new BaseResponse<T>()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Successfully Retrieved the data!");
    }
    public static  <T> BaseResponse<T> notFound(){
        return  new BaseResponse<T>()
                .setStatus(HttpStatus.NOT_FOUND.value())
                .setMessage("Item not found");
    }

    public static  <T> BaseResponse<T> badRequest(){
        return  new BaseResponse<T>()
                .setStatus(HttpStatus.BAD_REQUEST.value())
                .setMessage("Bad request provided");
    }
    public static  <T> BaseResponse<T> updateSuccess(){
        return  new BaseResponse<T>()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Successfully update  data!");
    }
    public static  <T> BaseResponse<T> deleteSuccess(){
        return  new BaseResponse<T>()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Successfully delete  data!");
    }
    public static <T> BaseResponse<T> disableSuccess(){
        return  new BaseResponse<T>()
                .setStatus(HttpStatus.OK.value())
                .setMessage("Successfully disable  data!");
    }
}
