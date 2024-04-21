package com.example.demo.service;

import com.example.demo.api.model.RegistrationBody;
import com.example.demo.api.model.RegistrationBodyProduct;
import com.example.demo.api.model.UserUsername;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ServiceUserTest {
    @Mock
    private UserDAO userDAOmock;
    private ServiceUser serviceUser;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        serviceUser = new ServiceUser(userDAOmock);

    }

    @Test
    public void registerUserTest(){
        RegistrationBody userBody = new RegistrationBody();
        userBody.setEmail("ioanabadea@yahoo.com");
        userBody.setUsername("ionica");
        userBody.setPassword("istc06BCI");
        userBody.setRole("buyer");

        User userCreated = new User();
        userCreated.setId(userBody.getId());
        userCreated.setEmail(userBody.getEmail());
        userCreated.setUsername(userBody.getUsername());
        userCreated.setPassword(userBody.getPassword());
        userCreated.setRole(userBody.getRole());
        Mockito.when(userDAOmock.save(userCreated)).thenReturn(userCreated);
        User user = serviceUser.registerUser(userBody);
        assertEquals(userCreated, user);
        Mockito.verify(userDAOmock).save(userCreated);
    }
    @Test
    public void findUserTest(){
        RegistrationBody userData = new RegistrationBody();
        serviceUser.findUser(userData);
        Mockito.verify(userDAOmock).findByUsername(userData.getUsername());
    }
    @Test
    public void updateUserTest() {

        RegistrationBody userData = new RegistrationBody();
        Mockito.when(serviceUser.findUserByUsername(new UserUsername())).thenReturn(new User());
        User user = serviceUser.updateUser(userData);
        Mockito.verify(userDAOmock).findByUsername(userData.getUsername());
    }

    @Test
    public void deleteUserTest(){
        RegistrationBody userData = new RegistrationBody();
        User user = serviceUser.deleteUser(userData);
        Mockito.verify(userDAOmock).delete(user);
    }
    @Test
    public void findUserByUsernameTest(){
        UserUsername user = new UserUsername();
        serviceUser.findUserByUsername(user);
        Mockito.verify(userDAOmock).findByUsername(user.getUsername());
    }

}
