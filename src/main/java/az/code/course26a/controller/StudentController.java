package az.code.course26a.controller;

import az.code.course26a.dto.StudentDTO;
import az.code.course26a.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private  final StudentService studentService;

    public StudentController(  StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    List<StudentDTO> getStudent(){
  return studentService.getAllStudents();
    }










}
