package global.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

    private final String message;

    private String errorId;
    public ErrorResponse(String message) {
        this.message = message;
    }

    public  ErrorResponse(String message, String errorId){
        this.message = message;
        this.errorId = errorId;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }
}
