package az.code.course26a.service.impl;

import az.code.course26a.dto.StudentDTO;
import az.code.course26a.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HarvardStudentServiceImpl implements StudentService {
    @Override
    public List<StudentDTO> getAllStudents() {
        return List.of(StudentDTO.builder().name("Babek").build());
    }

    @Override
    public StudentDTO findStudentById(Long id) {
        return null;
    }
}
