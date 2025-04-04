package com.victorgroup.hipermercadovic.apirest.data;

import com.victorgroup.hipermercadovic.apirest.models.UserEntity;
import com.victorgroup.hipermercadovic.apirest.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;
@RequiredArgsConstructor
@Component
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent>{

    private final UserEntityRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        createDefaultUserIfNotExits();
    }

    private void createDefaultUserIfNotExits(){
        for (int i = 1; i<=5; i++){
            String defaultEmail = "user"+i+"@email.com";
            if (userRepository.existsByEmail(defaultEmail)){
                continue;
            }
            UserEntity user = new UserEntity();
            user.setFirstName("The User");
            user.setLastName("User" + i);
            user.setEmail(defaultEmail);
            user.setPassword(passwordEncoder.encode("123456"));
            userRepository.save(user);
            System.out.println("Default vet user " + i + " created successfully.");
        }
    }

}
