package com.example.repository;

import com.example.entity.SalonService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalonServiceRepository extends JpaRepository<SalonService, Long> {
    // Hizmet adını kullanarak hizmeti bul
    List<SalonService> findAllByName(String name);
}
