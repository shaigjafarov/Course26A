package az.code.course26a.dto;


import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class StudentDTO {

    private  String name;

    private String surname;
}
