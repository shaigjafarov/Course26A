package az.code.course26a.service;

import az.code.course26a.entity.Employee;
import az.code.course26a.exception.EmployeeNotFoundException;
import az.code.course26a.repository.EmployeeRepoJpa;
import az.code.course26a.repository.EmployeeRepository;
import az.code.course26a.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;



@ExtendWith(MockitoExtension.class)
public class EmployerServiceTest {
    @Mock
    EmployeeRepository employeeRepository;

    @Mock
    EmployeeRepoJpa employeeRepoJpa;

    @Mock
    Environment environment;

    @InjectMocks
    EmployeeServiceImpl employeeService;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImpl(environment, employeeRepository, employeeRepoJpa);
//        ReflectionTestUtils.setField(employeeService, "applicationVersion", "1.0.0"); // Set the applicationVersion field using ReflectionTestUtils
    }


    @Test
    void findEmployeeByIDSuccess() {
        Employee employee = new Employee();
        employee.setName("salam");
        employee.setSurname("salam");
        employee.setId(12L);
        when(employeeRepoJpa.getById(anyLong())).thenReturn(employee);
        assertEquals(employee, employeeService.getById(anyLong()));
    }


    @Test
    void findEmployeeByIDFail() {
        when(employeeRepoJpa.getById(12L)).thenReturn(null);
        assertThrows(EmployeeNotFoundException.class, ()->employeeService.getById(12L));
    }


}
