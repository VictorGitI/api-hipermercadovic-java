package com.victorgroup.hipermercadovic.apirest.security.user;

import com.victorgroup.hipermercadovic.apirest.models.UserEntity;
import com.victorgroup.hipermercadovic.apirest.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class HypermarketUserDetailsService implements UserDetailsService {

    private UserEntityRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserEntity user = Optional.ofNullable(userRepository.findByEmail(email))
                .orElseThrow(()->new UsernameNotFoundException("User not found!"));
        return HypermarketUserDetails.buildUserDetails(user);
    }
}
