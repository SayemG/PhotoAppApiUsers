package com.microservice.photoapp.api.users.service;

import com.microservice.photoapp.api.users.data.UserEntity;
import com.microservice.photoapp.api.users.data.UserRepository;
import com.microservice.photoapp.api.users.shared.UserDto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class UserServiceImpl implements UsersService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCriptPasswordEncoder;

    @Autowired
    UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){

        this.userRepository = userRepository;
        this.bCriptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        userDetails.setEncryptedPassword(bCriptPasswordEncoder.encode(userDetails.getPassword()));
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserEntity userEntity = mapper.map(userDetails, UserEntity.class);
       //userEntity.setEncryptedPassword(String.valueOf(Math.random()));
        userRepository.save(userEntity);
        UserDto returnValue = mapper.map(userEntity, UserDto.class);

        return returnValue;
    }
}
