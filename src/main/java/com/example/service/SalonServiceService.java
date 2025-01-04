package com.example.service;


import com.example.entity.SalonService;
import com.example.repository.SalonServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalonServiceService {

    private final SalonServiceRepository salonServiceRepository;

    // Yeni bir hizmet ekle
    public SalonService addService(SalonService service) {
        return salonServiceRepository.save(service);
    }



    // Tüm hizmetleri getir
    public List<SalonService> getAllServices() {
        return salonServiceRepository.findAll();
    }


}
