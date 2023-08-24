package az.code.course26a.controller;

import az.code.course26a.dto.ResponseModel;
import az.code.course26a.dto.StudentDTO;
import az.code.course26a.enums.LanguageEnum;
import az.code.course26a.exception.StudentNotFoundException;
import az.code.course26a.service.StudentService;
import az.code.course26a.util.TranslateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    boolean saveStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.saveStudent(studentDTO);
    }

    @GetMapping("/all")
    List<StudentDTO> getStudent() {
        return studentService.getAllStudents();
    }
    @GetMapping
    ResponseEntity<ResponseModel<StudentDTO>> getStudentById(
            @RequestParam("studentId") Integer id,
            @RequestHeader(value = "Accept-Language", required = false, defaultValue = "AZ") LanguageEnum languageEnum) {
        try {
            ResponseModel<StudentDTO> studentDTOResponseModel= new ResponseModel<>();
            studentDTOResponseModel.setData(studentService.findStudentById(id));
            studentDTOResponseModel.setMessage("success");
            return  new ResponseEntity<>(studentDTOResponseModel, HttpStatus.CREATED);
        }catch (StudentNotFoundException e){
            ResponseModel<StudentDTO> studentDTOResponseModel= new ResponseModel<>();
            studentDTOResponseModel.setMessage(TranslateUtil.translate(languageEnum,e.getMessage())+id);
            return new ResponseEntity<>(studentDTOResponseModel, HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/{studentId}")
    StudentDTO getStudentByIdWithPath(@PathVariable("studentId") Integer id) {
        return studentService.findStudentById(id);
    }


}
