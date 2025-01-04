package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "salonService", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore // Sonsuz döngüyü önlemek için
    private List<Appointment> appointments = new ArrayList<>(); // Varsayılan olarak boş liste
}
