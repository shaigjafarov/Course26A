package az.code.course26a.service.impl;

import az.code.course26a.config.JwtUtil;
import az.code.course26a.dto.UserDTO;
import az.code.course26a.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private  final JwtUtil jwtUtil;
    @Override
    public String getToken(UserDTO userDTO) {
        return  jwtUtil.createToken(userDTO.getName(), userDTO.getSurname(), userDTO.getMail());
    }
}
