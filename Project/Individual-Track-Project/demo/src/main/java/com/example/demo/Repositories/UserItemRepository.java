package com.example.demo.Repositories;

import com.example.demo.RepositoryClasses.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserItemRepository extends JpaRepository<User, Long> {
   User findByUsername(String username);
}
