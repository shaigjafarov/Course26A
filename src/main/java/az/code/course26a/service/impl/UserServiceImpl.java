package az.code.course26a.service.impl;

import az.code.course26a.dto.CustomUserDetails;
import az.code.course26a.dto.UserSecDTO;
import az.code.course26a.entity.Role;
import az.code.course26a.entity.UserEntity;
import az.code.course26a.repository.UserRepository;
import az.code.course26a.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Stream;

@Service("userser")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService , UserDetailsService {

   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void saveUser(UserSecDTO user) {
        Role role = Role.builder().id(1L).name("USER").build();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity userEntity = UserEntity.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(Set.of(role))
                .build();
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);



        return User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword()) // Encrypted password for "password"
                .roles(userEntity.getRoles().stream().map(Role::getName).toArray(String[]::new))
                .build();
    }
}
