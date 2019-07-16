package com.example.demo.repository;

import com.example.demo.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TUserRepository extends JpaRepository<TUser,Long> {
}
