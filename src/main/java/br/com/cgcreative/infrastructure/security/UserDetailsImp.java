package br.com.cgcreative.infrastructure.security;

import br.com.cgcreative.domain.user.User;
import br.com.cgcreative.infrastructure.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@AllArgsConstructor
public class UserDetailsImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var entity = userRepository.findByName(username).orElseThrow(() -> new NullPointerException(""));
        return new User(entity.getName(), entity.getPassword(), Collections.singleton(entity.getRole()));
    }
}
