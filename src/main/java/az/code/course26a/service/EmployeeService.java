package az.code.course26a.service;

import az.code.course26a.dto.EmployeeDTO;
import az.code.course26a.dto.ResponseModel;
import az.code.course26a.entity.Department;
import az.code.course26a.entity.Employee;

import java.util.List;

public interface EmployeeService {


    ResponseModel<EmployeeDTO> getEmployeeById (Long id);


    void  saveEmployee(Department department);

    List<Employee> getEmpByName(String name );



}
