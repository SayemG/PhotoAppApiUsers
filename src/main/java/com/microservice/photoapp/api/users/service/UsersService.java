package com.microservice.photoapp.api.users.service;

import com.microservice.photoapp.api.users.shared.UserDto;
import org.springframework.stereotype.Service;


@Service
public interface UsersService {
    UserDto createUser(UserDto userDetails);
}
