package az.code.course26a.util;

import az.code.course26a.dto.EmpMap;
import az.code.course26a.dto.EmployeeDTO;
import az.code.course26a.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmpMapper {
    EmpMapper INSTANCE = Mappers.getMapper(EmpMapper.class);

    @Mapping(source = "name", target = "name1")
    @Mapping(source = "surname", target = "surname1")
        // Example mapping
    EmpMap empToEmpDTO(Employee employee);
}