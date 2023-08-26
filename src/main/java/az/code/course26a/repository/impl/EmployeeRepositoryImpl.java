package az.code.course26a.repository.impl;


import az.code.course26a.entity.Department;
import az.code.course26a.entity.Employee;
import az.code.course26a.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {



    private final EntityManager entityManager;


    public Employee getById(Long id) {
        try {
            Employee employee = entityManager.find(Employee.class, id);
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveDepartment(Department departmentReceived) {
        try {
            if (departmentReceived.getId() == null) {
                if (!departmentReceived.getEmployeeList().isEmpty())
                    for (Employee employee : departmentReceived.getEmployeeList()) {
                        employee.setDepartment(departmentReceived);
                    }
                entityManager.merge(departmentReceived);

            }
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
