package az.code.course26a.service.impl;

import az.code.course26a.dto.EmpMap;
import az.code.course26a.dto.EmployeeDTO;
import az.code.course26a.dto.ResponseModel;
import az.code.course26a.dto.StudentDTO;
import az.code.course26a.entity.Department;
import az.code.course26a.entity.Employee;
import az.code.course26a.exception.EmployeeNotFoundException;
import az.code.course26a.repository.EmployeeRepoJpa;
import az.code.course26a.repository.EmployeeRepository;
import az.code.course26a.service.EmployeeService;
import az.code.course26a.util.EmpMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class EmployeeServiceImpl implements EmployeeService {

//    Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);

//    @Value("${course.proje.version}")
//    String applicationVersion;
//

    private final Environment environment;
    private final EmployeeRepository employeeRepository;
    private final EmployeeRepoJpa employeeRepoJpa;


    @Override
    public ResponseModel<EmployeeDTO> getEmployeeById(Long id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("received employee id: " + id);
//        if (applicationVersion != null) {
//            System.out.println(applicationVersion);
//        }
        System.out.println(environment.getProperty("student.default.name"));

        ;
//        Employee employee= employeeRepository.getById(id);


        Employee employee = employeeRepoJpa.getById(id);


        log.info("employee in db: " + employee);

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
    public Employee getById(Long id) {
        Employee employee = employeeRepoJpa.getById(id);
        if (employee == null) {
            throw new EmployeeNotFoundException(id + " ile user tapilmadi");
        } else
            return employee;
    }

    @Override
    @Transactional
    public void saveEmployee(Department department) {
        employeeRepository.saveDepartment(department);

    }

    @Override
    public List<Employee> getEmpByName(String name) {
        return employeeRepoJpa.getEmployeeByName(name);
    }

    @Override
    @Transactional
    public void updateById(Long id, String name) {
        employeeRepoJpa.updateById(id, name);

    }

    @Override
    public EmployeeDTO getEmpDTOById(Long id) {
        EmployeeDTO empDTOById = employeeRepoJpa.getEmpDTOById(id);
        if (empDTOById == null)
            throw new EmployeeNotFoundException(id + " id-si ilə işçi tapılmadı.");
        return empDTOById;
    }

    @Override
    public void saveEmp(EmpMap empMap) {
        Employee employee = EmpMapper.INSTANCE.empDtoToEmp(empMap);
        employeeRepoJpa.save(employee);
    }


    @Override
    public Employee getEmpNaById(Long id) {
        return employeeRepoJpa.getEmpNaById(id);
    }

    @Override
    public List<Employee> getEmployeeByName(String name, Pageable pageable) {
        return employeeRepoJpa.getEmployeeByName(name, pageable);
    }

    @Override
    public Page<Employee> getEmployeePage(PageRequest pageRequest) {

//        List<Employee> employees = employeeRepoJpa.getAllBy(pageRequest);

//        return  new PageImpl<>(employees, pageRequest,100l);
        return employeeRepoJpa.getAllBy(pageRequest);
    }


}
