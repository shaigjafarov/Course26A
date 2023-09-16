package az.code.course26a.service;

import az.code.course26a.entity.UserEntity;
import az.code.course26a.entity.Role;
import az.code.course26a.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    private final UserRepository userRepository;
//
//    public CustomUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity userEntity = userRepository.findByUsername(username);
//
//        if (userEntity == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        return User.withUsername(userEntity.getUsername())
//            .password(userEntity.getPassword())
//            .roles(userEntity.getRoles().stream().map(Role::getName).toArray(String[]::new))
//            .build();
//    }
//}


