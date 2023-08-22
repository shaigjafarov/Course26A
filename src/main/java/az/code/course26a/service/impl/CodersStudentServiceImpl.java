package az.code.course26a.service.impl;

import az.code.course26a.dto.StudentDTO;
import az.code.course26a.service.StudentService;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@Lazy
public class CodersStudentServiceImpl  implements StudentService {


    @Override
    public List<StudentDTO> getAllStudents() {
        return List.of(StudentDTO.builder().name("Nihat").build());
    }

    @Override
    public StudentDTO findStudentById(Long id) {
        return null;
    }
}
