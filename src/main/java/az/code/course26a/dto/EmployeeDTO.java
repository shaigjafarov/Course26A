package az.code.course26a.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {


    Long id;
    String name;
    String surname;
}
