package az.code.course26a.service;

import az.code.course26a.dto.UserDTO;
import az.code.course26a.dto.UserSecDTO;
import az.code.course26a.entity.UserEntity;

public interface UserService {
    
    
    void saveUser(UserSecDTO userSecDTO );

    UserEntity findByUsername(String username);
}
