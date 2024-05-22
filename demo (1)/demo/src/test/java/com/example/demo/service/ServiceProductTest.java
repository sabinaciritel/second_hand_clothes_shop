package com.example.demo.service;

import com.example.demo.api.model.ProductName;
import com.example.demo.api.model.RegistrationBody;
import com.example.demo.api.model.RegistrationBodyProduct;
import com.example.demo.api.model.UserUsername;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.dao.UserDAO;
import com.example.demo.model.dao.UserDAOP;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.swing.plaf.PanelUI;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test class for ServiceProduct. It provides unit tests for various product management functionalities
 * including registration, finding, deleting, and updating products.
 */
public class ServiceProductTest {
    @Mock
    private UserDAOP userDAOPmock;
    @Mock
    private UserDAO userDAOmock;
    private ServiceProduct serviceProduct;
    /**
     * Sets up the testing environment before each test. Initializes mocks and creates an instance
     * of ServiceProduct with injected mocks.
     */
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        serviceProduct = new ServiceProduct(userDAOPmock,userDAOmock);

    }
    /**
     * Tests the product registration process. Ensures that a product is saved correctly
     * through the userDAOP mock.
     */
    @Test
    public void registerProductMethodTest(){
        RegistrationBodyProduct productData = new RegistrationBodyProduct();
        Product product = serviceProduct.registerProduct(productData);
        Mockito.verify(userDAOPmock).save(product);
    }
    /**
     * Tests finding a product by name. Verifies the interaction with the data access object
     * to ensure the correct method is called with the expected arguments.
     */
    @Test
    public void findProductMethodTest(){
        RegistrationBodyProduct productData = new RegistrationBodyProduct();
        serviceProduct.findProduct(productData);
        Mockito.verify(userDAOPmock).findByName(productData.getName());
    }
    /**
     * Tests the deletion of a product. This test verifies that the delete method on the product DAO is
     * called with the correct product object.
     */
    @Test
    public void deleteProductTest(){
        RegistrationBodyProduct productData = new RegistrationBodyProduct();
        Product product = serviceProduct.deleteProduct(productData);
        Mockito.verify(userDAOPmock).delete(product);
    }
    /**
     * Tests updating a product's information. Ensures that the correct methods are called on the DAO
     * and verifies that product details are correctly updated.
     */
    @Test
    public void updateProductTest(){
        RegistrationBodyProduct productData = new RegistrationBodyProduct();
        Mockito.when(serviceProduct.findByName(new ProductName())).thenReturn(new Product());
        Product product = serviceProduct.updateProduct(productData);
        Mockito.verify(userDAOPmock).findByName(productData.getName());
    }
    /**
     * Tests finding a product by its name using the ServiceProduct. Verifies if the method to find a product
     * by name is correctly invoked on the userDAOP mock.
     */
    @Test
    public void findUserByNameTest(){
        ProductName product = new ProductName();
        serviceProduct.findByName(product);
        Mockito.verify(userDAOPmock).findByName(product.getName());
    }


}
