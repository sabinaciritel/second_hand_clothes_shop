package com.example.demo.service;

import com.example.demo.api.model.RegistrationBody;
import com.example.demo.api.model.RegistrationBodyOrder;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.User;

public interface ServiceOrderImpl {
    Order registerOrder(RegistrationBodyOrder orderData);
    Order updateOrder(RegistrationBodyOrder orderData);
    Order deleteOrder(RegistrationBodyOrder orderData);
    Order findOrder(RegistrationBodyOrder orderData);
}
