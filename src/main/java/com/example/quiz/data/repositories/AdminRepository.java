package com.example.quiz.data.repositories;

import com.example.quiz.data.models.Admin;
import com.example.quiz.dtos.requests.RegisterAdminRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findAdminByUsername(String username);
}
