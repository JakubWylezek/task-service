package com.taskservice.taskservice.respository;

import com.taskservice.taskservice.model.Border;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorderRepository extends JpaRepository<Border, Long> {

    Optional<Border> getByName(String name);
}
