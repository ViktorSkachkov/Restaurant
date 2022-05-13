package com.example.demo.Repositories;

import com.example.demo.Normal.TableItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableItemRepository extends JpaRepository<TableItem, Long> {
    boolean existsById(int id);
}
