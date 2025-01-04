package com.example.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Otomatik artan birincil anahtar

    private String customerName; // Randevuyu alan müşterinin adı

    private LocalDateTime appointmentDate; // Randevu tarihi ve saati

    private String phoneNumber; // Müşterinin telefon numarası

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false) // Yabancı anahtar kolonu
    @JsonBackReference // JSON serileştirmede döngüyü kırmak için
    private SalonService salonService; // Randevunun ilişkili olduğu hizmet

    private double price; // Hizmetin fiyatı (yeni alan)

    private String status = "Beklemede"; // Varsayılan durum
}
