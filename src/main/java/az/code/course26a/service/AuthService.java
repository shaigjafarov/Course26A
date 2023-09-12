package az.code.course26a.service;

import az.code.course26a.dto.UserDTO;

public interface AuthService {

    String getToken(UserDTO userDTO);
}
