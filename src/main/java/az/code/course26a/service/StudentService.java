package az.code.course26a.service;

import az.code.course26a.dto.StudentDTO;

import java.util.List;

public interface StudentService {

    List<StudentDTO> getAllStudents();


    StudentDTO findStudentById(Integer id);


    boolean saveStudent(StudentDTO studentDTO);
}
