package com.example.repository;


import com.example.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Belirli bir müşteriye ait randevuları listele
    List<Appointment> findByCustomerName(String customerName);
}
