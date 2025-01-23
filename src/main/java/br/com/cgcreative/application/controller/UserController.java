package br.com.cgcreative.application.controller;

import br.com.cgcreative.application.api.IUserController;
import br.com.cgcreative.application.api.request.UserRequest;
import br.com.cgcreative.application.api.response.TokenResponse;
import br.com.cgcreative.application.api.response.UserResponse;
import br.com.cgcreative.domain.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController implements IUserController {

    private final IUserService userService;

    @Override
    public ResponseEntity<TokenResponse> signIn(UserRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.signin(request));
    }

    @Override
    public ResponseEntity<UserResponse> create(UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(request));
    }
}
