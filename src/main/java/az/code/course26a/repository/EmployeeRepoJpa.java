package az.code.course26a.repository;

import az.code.course26a.dto.EmployeeDTO;
import az.code.course26a.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepoJpa extends JpaRepository<Employee, Long> {


    List<Employee> getEmployeeByName(String name);




//    void updateEmpName(String name, Long id);



//    void  updateNById(Long id, String name);


    @Query("update Employee  e set e.name=:name  where e.id=:id")
    @Modifying
    void updateById(Long id, String name);



    @Query("select new az.code.course26a.dto.EmployeeDTO(e.id,e.name,e.surname) from Employee  e where e.id=:id ")
    EmployeeDTO getEmpDTOById(Long id);


    List<Employee> getEmployeeByName(String name,Pageable pageable);



    @Query(value = "select * from course_proje.Employes  e where e.id=:id ", nativeQuery = true)
    Employee getEmpNaById(Long id);


    Page<Employee>  getAllBy(Pageable pageable);


//    @Query(value = "select e.id id,e.name name,e.surname surname from course_proje.Employes  e where e.id=:id ", nativeQuery = true)
//    EmployeeDTO getEmpNaDTOById(Long id);













}
