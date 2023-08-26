package az.code.course26a.repository;

import az.code.course26a.entity.Department;
import az.code.course26a.entity.Employee;

public interface EmployeeRepository {
    Employee getById(Long id);
     void saveDepartment(Department departmentReceived);
}
