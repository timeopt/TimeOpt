package com.example.demo.repository;

import com.example.demo.entity.Tokeners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenersRepository extends JpaRepository<Tokeners,Long> {
}
