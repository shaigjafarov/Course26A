package az.code.course26a.service;
import az.code.course26a.entity.Employee;
import az.code.course26a.repository.EmployeeRepoJpa;
import az.code.course26a.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
@ActiveProfiles("test")
public class EmployerServiceIntegrationTest {

    @Autowired
    private EmployeeRepoJpa employeeRepoJpa;






    @Test
    public void testSaveAndRetrieveData() {
        Employee entity = new Employee();
        entity.setId(1L);
        entity.setName("Salam");
        entity.setSurname("Salamov");
        employeeRepoJpa.save(entity);

        Employee retrievedEntity = employeeRepoJpa.findById(entity.getId()).orElse(null);
        assertEquals(entity, retrievedEntity);
    }
}