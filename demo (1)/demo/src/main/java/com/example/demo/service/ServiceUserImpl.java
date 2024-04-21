package com.example.demo.service;

import com.example.demo.api.model.RegistrationBody;
import com.example.demo.model.User;

public interface ServiceUserImpl {
    User registerUser(RegistrationBody userData);
    User updateUser(RegistrationBody userData);
    User deleteUser(RegistrationBody userData);
    User findUser(RegistrationBody userData);
}
