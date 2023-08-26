package az.code.course26a.repository;

import az.code.course26a.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepoJpa extends JpaRepository<Employee, Long> {


    List<Employee> getEmployeeByName(String name);



}
