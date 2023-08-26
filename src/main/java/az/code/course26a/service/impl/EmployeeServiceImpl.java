package az.code.course26a.service.impl;

import az.code.course26a.dto.EmployeeDTO;
import az.code.course26a.dto.ResponseModel;
import az.code.course26a.dto.StudentDTO;
import az.code.course26a.entity.Department;
import az.code.course26a.entity.Employee;
import az.code.course26a.repository.EmployeeRepoJpa;
import az.code.course26a.repository.EmployeeRepository;
import az.code.course26a.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private  final EmployeeRepository employeeRepository;
    private  final EmployeeRepoJpa employeeRepoJpa;





    @Override
    public ResponseModel<EmployeeDTO> getEmployeeById(Long id) {
//        Employee employee= employeeRepository.getById(id);


        Employee employee = employeeRepoJpa.getById(id);
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .name(employee.getName())
                .surname(employee.getSurname())
                .id(employee.getId())
                .build();

        ResponseModel<EmployeeDTO> employeeDTOResponseModel = new ResponseModel<>();
        employeeDTOResponseModel.setData(employeeDTO);
        employeeDTOResponseModel.setMessage("Success");
        return employeeDTOResponseModel;
    }

    @Override
    @Transactional
    public void saveEmployee(Department department) {
        employeeRepository.saveDepartment(department);

    }

    @Override
    public List<Employee> getEmpByName(String name) {
        return employeeRepoJpa.getEmployeeByName(name);    }


}
