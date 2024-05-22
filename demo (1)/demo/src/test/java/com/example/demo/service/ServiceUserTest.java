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
/**
 * Test class for ServiceUser. It provides unit tests for user management functionalities
 * such as registering, finding, updating, and deleting users.
 */
public class ServiceUserTest {
    @Mock
    private UserDAO userDAOmock;
    private ServiceUser serviceUser;
    /**
     * Sets up the test environment. Initializes mocks and creates an instance
     * of ServiceUser with the mocked DAO.
     */
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        serviceUser = new ServiceUser(userDAOmock);

    }
    /**
     * Tests the user registration functionality to ensure that the user is saved correctly and
     * that the saved user matches the expected user object.
     */
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
    /**
     * Tests the functionality to find a user by username. Verifies that the correct method
     * on the DAO is called to find a user based on the username provided in the user data.
     */
    @Test
    public void findUserTest(){
        RegistrationBody userData = new RegistrationBody();
        serviceUser.findUser(userData);
        Mockito.verify(userDAOmock).findByUsername(userData.getUsername());
    }
    /**
     * Tests updating a user's details. This test checks the process of updating a user
     * after retrieving their details based on username.
     */
    @Test
    public void updateUserTest() {

        RegistrationBody userData = new RegistrationBody();
        Mockito.when(serviceUser.findUserByUsername(new UserUsername())).thenReturn(new User());
        User user = serviceUser.updateUser(userData);
        Mockito.verify(userDAOmock).findByUsername(userData.getUsername());
    }
    /**
     * Tests the deletion of a user. Ensures that the DAO's delete method is called with
     * the correct user object.
     */
    @Test
    public void deleteUserTest(){
        RegistrationBody userData = new RegistrationBody();
        User user = serviceUser.deleteUser(userData);
        Mockito.verify(userDAOmock).delete(user);
    }
    /**
     * Tests finding a user by their username using the ServiceUser. Verifies if the method
     * to find a user by username is correctly invoked on the DAO mock.
     */
    @Test
    public void findUserByUsernameTest(){
        UserUsername user = new UserUsername();
        serviceUser.findUserByUsername(user);
        Mockito.verify(userDAOmock).findByUsername(user.getUsername());
    }

}
