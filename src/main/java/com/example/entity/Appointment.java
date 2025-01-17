package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Otomatik artan birincil anahtar

    private String customerName; // Randevuyu alan müşterinin adı

    private LocalDate appointmentDate; // Randevu tarihi (sadece gün/ay/yıl)

    private String phoneNumber; // Müşterinin telefon numarası (herhangi bir format kontrolü yok)

    private String salonServiceName; // Hizmet adı

    private double price; // Hizmetin fiyatı (yeni alan)

    private String status = "Beklemede"; // Varsayılan durum
}
