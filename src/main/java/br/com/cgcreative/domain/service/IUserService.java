package br.com.cgcreative.domain.service;

import br.com.cgcreative.application.api.request.UserRequest;
import br.com.cgcreative.application.api.response.TokenResponse;
import br.com.cgcreative.application.api.response.UserResponse;

public interface IUserService {
    TokenResponse signin(UserRequest request);
    UserResponse create(UserRequest request);
}
