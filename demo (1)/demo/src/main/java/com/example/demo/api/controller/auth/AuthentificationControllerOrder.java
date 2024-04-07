//
//package com.example.demo.api.controller.auth;
//
//import com.example.demo.api.model.RegistrationBody;
//import com.example.demo.api.model.RegistrationBodyOrder;
//import com.example.demo.api.model.RegistrationBodyProduct;
//import com.example.demo.service.ServiceOrder;
//import com.example.demo.service.ServiceProduct;
//import com.example.demo.service.ServiceUser;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/authOrder")
//public class AuthentificationControllerOrder {
//    private ServiceOrder serviceOrder;
//
//    public AuthentificationControllerOrder(ServiceOrder serviceOrder) {
//        this.serviceOrder = serviceOrder;
//    }
//
//    @PostMapping("/registerOrder")
//    public void registerOrder(@RequestBody RegistrationBodyOrder registrationBodyOrder){
//        serviceOrder.registerOrder(registrationBodyOrder);
//
//    }
//    @GetMapping("/findOrder")
//    public void findOrder(@RequestBody RegistrationBodyOrder registrationBodyOrder){
//        serviceOrder.findOrder(registrationBodyOrder);
//
//    }
//    @PutMapping("/updateOrder")
//    public void putOrder(@RequestBody RegistrationBodyOrder registrationBodyOrder){
//        serviceOrder.updateOrder(registrationBodyOrder);
//
//    }
//    @DeleteMapping("/deleteOrder")
//    public void deleteOrder(@RequestBody RegistrationBodyOrder registrationBodyOrder){
//        serviceOrder.deleteOrder(registrationBodyOrder);
//
//    }
//
//
//
//}