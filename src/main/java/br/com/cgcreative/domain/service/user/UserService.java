package br.com.cgcreative.domain.service.user;

import br.com.cgcreative.application.api.request.UserRequest;
import br.com.cgcreative.application.api.response.TokenResponse;
import br.com.cgcreative.application.api.response.UserResponse;
import br.com.cgcreative.domain.entity.UserEntity;
import br.com.cgcreative.domain.mapper.GenericMapper;
import br.com.cgcreative.domain.service.IUserService;
import br.com.cgcreative.infrastructure.repository.UserRepository;
import br.com.cgcreative.infrastructure.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final GenericMapper mapper;

    @Override
    public TokenResponse signin(UserRequest request) {
        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getName(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        return new TokenResponse(jwtService.gerarToken(request.getName()));
    }

    @Override
    public UserResponse create(UserRequest request) {
        if (userRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("");
        }
        var entity = mapper.map(request, UserEntity.class);
        entity.setPassword(passwordEncoder.encode(request.getPassword()));
        return mapper.map(userRepository.save(entity), UserResponse.class);
    }
}
