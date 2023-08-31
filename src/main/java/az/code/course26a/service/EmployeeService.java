package az.code.course26a.service;

import az.code.course26a.dto.EmpMap;
import az.code.course26a.dto.EmployeeDTO;
import az.code.course26a.dto.ResponseModel;
import az.code.course26a.entity.Department;
import az.code.course26a.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {


    ResponseModel<EmployeeDTO> getEmployeeById (Long id);
    Employee getById (Long id);


    void  saveEmployee(Department department);

    List<Employee> getEmpByName(String name );

    void  updateById(Long id, String name);

    EmployeeDTO getEmpDTOById(Long id);


    void  saveEmp(EmpMap empMap);



    Employee getEmpNaById(Long id);

    List<Employee> getEmployeeByName(String name, Pageable pageable);


    Page<Employee> getEmployeePage(PageRequest of);
}
