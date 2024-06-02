package com.example.demo.model.dao;

import com.example.demo.model.Order;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDAOO extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);
    List<Order> findByUser(User user);
}
