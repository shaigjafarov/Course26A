package az.code.course26a.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@JacksonXmlRootElement(localName = "student")
public class StudentDTO {

    private Integer id;

    private  String name;

    private String surname;

}
