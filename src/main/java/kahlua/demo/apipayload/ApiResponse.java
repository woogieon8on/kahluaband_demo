package kahlua.demo.apipayload;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import kahlua.demo.apipayload.code.status.SuccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
@AllArgsConstructor
@Getter
public class ApiResponse<T> {

    private Boolean isSuccess;
    private String code;
    private String message;
    private T result;

    public static <T> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, SuccessStatus.OK.getCode(), SuccessStatus.OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> onFailure(String code, String message, T data) {
        return new ApiResponse<>(false, code, message, data);
    }
}
