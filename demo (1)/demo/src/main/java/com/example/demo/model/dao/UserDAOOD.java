package com.example.demo.model.dao;

import com.example.demo.model.OrderDetail;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDAOOD extends JpaRepository<OrderDetail, Long> {
    Optional<OrderDetail> findById(Long id);
    List<OrderDetail> findByUser(User user);
}
