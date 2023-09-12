package az.code.course26a.controller;


import az.code.course26a.dto.UserDTO;
import az.code.course26a.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;


    @PostMapping("/login")
    String getToken(@RequestBody UserDTO userDTO) {
        return authService.getToken(userDTO);
    }


}
