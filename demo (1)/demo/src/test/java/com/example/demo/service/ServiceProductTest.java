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

public class ServiceProductTest {
    @Mock
    private UserDAOP userDAOPmock;
    @Mock
    private UserDAO userDAOmock;
    private ServiceProduct serviceProduct;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        serviceProduct = new ServiceProduct(userDAOPmock,userDAOmock);

    }

    @Test
    public void registerProductMethodTest(){
        RegistrationBodyProduct productData = new RegistrationBodyProduct();
        Product product = serviceProduct.registerProduct(productData);
        Mockito.verify(userDAOPmock).save(product);
    }

    @Test
    public void findProductMethodTest(){
        RegistrationBodyProduct productData = new RegistrationBodyProduct();
        serviceProduct.findProduct(productData);
        Mockito.verify(userDAOPmock).findByName(productData.getName());
    }
    @Test
    public void deleteProductTest(){
        RegistrationBodyProduct productData = new RegistrationBodyProduct();
        Product product = serviceProduct.deleteProduct(productData);
        Mockito.verify(userDAOPmock).delete(product);
    }
    @Test
    public void updateProductTest(){
        RegistrationBodyProduct productData = new RegistrationBodyProduct();
        Mockito.when(serviceProduct.findByName(new ProductName())).thenReturn(new Product());
        Product product = serviceProduct.updateProduct(productData);
        Mockito.verify(userDAOPmock).findByName(productData.getName());
    }
    @Test
    public void findUserByNameTest(){
        ProductName product = new ProductName();
        serviceProduct.findByName(product);
        Mockito.verify(userDAOPmock).findByName(product.getName());
    }


}
