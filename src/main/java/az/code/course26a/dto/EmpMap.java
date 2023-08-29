package az.code.course26a.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpMap {

    String name1;
    String surname1;

    public EmpMap( String name, String surname) {
        this.name1 = name;
        this.surname1 = surname;
    }
}
