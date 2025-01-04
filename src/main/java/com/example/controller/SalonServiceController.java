package com.example.controller;


import com.example.entity.SalonService;
import com.example.service.SalonServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class SalonServiceController {

    private final SalonServiceService salonServiceService;

    // Yeni bir hizmet ekle
    @PostMapping("/add") // http://localhost:8080/api/services/add + POST
    public SalonService addService(@RequestBody SalonService service) {
        return salonServiceService.addService(service);
    }

    // Tüm hizmetleri getir
    @GetMapping("/list") // http://localhost:8080/api/services/list + GET
    public List<SalonService> getAllServices() {
        return salonServiceService.getAllServices();
    }
}
