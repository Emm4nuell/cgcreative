package br.com.cgcreative.application.api;

import br.com.cgcreative.application.api.request.UserRequest;
import br.com.cgcreative.application.api.response.TokenResponse;
import br.com.cgcreative.application.api.response.UserResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/user")
public interface IUserController {

    @PostMapping(value = "/signin", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<TokenResponse> signIn(@RequestBody UserRequest request);

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponse> create(@RequestBody UserRequest request);
}
