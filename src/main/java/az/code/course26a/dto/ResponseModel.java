package az.code.course26a.dto;

import lombok.Data;

@Data
public class ResponseModel<T>{

    T data;

    String message;


}
