package az.code.course26a.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @Column(name = "head_fullname")
    String headFullName;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "department", cascade = CascadeType.ALL)
    @JsonProperty("employees")
    List<Employee> employeeList = new ArrayList<>();
    boolean empAdd(Employee employee) {
        return employeeList.add(employee);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadFullName() {
        return headFullName;
    }

    public void setHeadFullName(String headFullName) {
        this.headFullName = headFullName;
    }

    public Department(Long id, String name, String headFullName) {
        this.id = id;
        this.name = name;
        this.headFullName = headFullName;
    }


    public Department() {
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Department(Long id, String name, String headFullName, List<Employee> employeeList) {
        this.id = id;
        this.name = name;
        this.headFullName = headFullName;
        this.employeeList = employeeList;
    }
}
