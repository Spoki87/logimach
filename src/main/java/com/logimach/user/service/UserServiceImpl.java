package com.logimach.user.service;

import com.logimach.user.dto.CreateUserDto;
import com.logimach.user.dto.UserDto;
import com.logimach.user.excepion.EmailAlreadyTakenException;
import com.logimach.user.excepion.UserNotFoundException;
import com.logimach.user.model.User;
import com.logimach.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    public UserDto addUser(CreateUserDto request) {

        boolean userExist = userRepository.findByEmail(request.getEmail()).isPresent();

        if (userExist) {
            throw new EmailAlreadyTakenException();
        }

        User user = new User(
                request.getUsername(),
                request.getEmail(),
                bCryptPasswordEncoder.encode(request.getPassword())
        );

        userRepository.save(user);

        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getUsername()
        );
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

