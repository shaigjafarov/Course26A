package az.code.course26a.service.impl;

import az.code.course26a.dto.StudentDTO;
import az.code.course26a.exception.StudentNotFoundException;
import az.code.course26a.service.StudentService;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

@Service
@Primary
@Lazy
public class CodersStudentServiceImpl implements StudentService {

    private static Integer id = 1;

    private static Set<StudentDTO> studentDTOS = new HashSet<>();


    @Override
    public List<StudentDTO> getAllStudents() {
        return new ArrayList<>(studentDTOS);
    }

    @Override
    public StudentDTO findStudentById(Integer id) {
        Optional<StudentDTO> studentDTO = studentDTOS.stream().filter(stu -> stu.getId().equals(id)).findAny();
        if (studentDTO.isPresent()) {
            return studentDTO.get();
        } else {
            throw new StudentNotFoundException("student_not_found");
        }

    }

    @Override
    public boolean saveStudent(StudentDTO studentDTO) {
        try {
            studentDTO.setId(getIdFromSequence());
            return studentDTOS.add(studentDTO);
        } catch (Exception e) {
            return false;
        }
    }

    private Integer getIdFromSequence() {
        return ++id;
    }
}
