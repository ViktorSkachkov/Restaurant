package com.example.demo.Repositories;

import com.example.demo.Normal.TableItem;
import com.example.demo.Normal.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    boolean existsById(int id);
}
