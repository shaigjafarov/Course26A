package az.code.course26a.dto;

import lombok.Builder;
import lombok.Data;

@Builder
public class ResponseModel<T>{

    T data;

    String message;


    public ResponseModel() {
    }


    public ResponseModel(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
