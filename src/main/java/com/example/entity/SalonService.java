package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalonService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Otomatik artan birincil anahtar

    private String name; // Hizmet adı (örneğin, "Saç Kesimi")

    private String description; // Hizmet açıklaması

    private double price; // Hizmet fiyatı

    private int duration; // Hizmet süresi (dakika cinsinden)
}
