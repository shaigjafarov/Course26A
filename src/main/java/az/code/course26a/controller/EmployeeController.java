package az.code.course26a.controller;

import az.code.course26a.dto.EmpMap;
import az.code.course26a.dto.EmployeeDTO;
import az.code.course26a.dto.ResponseModel;
import az.code.course26a.entity.Department;
import az.code.course26a.entity.Employee;
import az.code.course26a.exception.NotFoundException;
import az.code.course26a.service.EmployeeService;
import az.code.course26a.util.EmpMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;




    @GetMapping
    ResponseModel<EmployeeDTO> getEmp(@RequestParam Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/map")
    EmpMap getEmpasd(@RequestParam Long id) {
        Employee byId = employeeService.getById(id);
        EmpMap employeeDTO = EmpMapper.INSTANCE.empToEmpDTO(byId);
        return employeeDTO;
    }

    @PostMapping
    void saveDepart(@RequestBody Department department) {
        employeeService.saveEmployee(department);
    }


    @GetMapping("/name")
    List<Employee> getEmpWithName(@RequestParam String name) {
        return employeeService.getEmpByName(name);
    }

    @PutMapping
    void upEmpName(@RequestParam Long id, @RequestParam String name) {
        employeeService.updateById(id, name);
    }


    @GetMapping("/dto")
    EmployeeDTO upEmpName(@RequestParam Long id) {
        return employeeService.getEmpDTOById(id);
    }



    @PostMapping("/save")
    void saveEmp(@RequestBody EmpMap empMap) {
        employeeService.saveEmp(empMap);
    }





    @GetMapping("/sql")
    Employee upEmpSQLName(@RequestParam Long id) {
        return employeeService.getEmpNaById(id);
    }


    @GetMapping("/all")
    List<Employee> employeeList (@RequestParam String name,
                                 @RequestParam Integer page,
                                 @RequestParam(value = "size", defaultValue = "6", required = false) Integer size ){
        return employeeService.getEmployeeByName(name,PageRequest.of(page,size));

    }



    @GetMapping("/page")
    Page<Employee> employeePage (@RequestParam Integer page,
                                 @RequestParam(value = "size", defaultValue = "6", required = false) Integer size ){
//        return employeeService.getEmployeePage(PageRequest.of(page,size));
        return employeeService.getEmployeePage(PageRequest.of(page,size, Sort.by(Sort.Direction.ASC, "name")));

    }

}
