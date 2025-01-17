package com.example.service;

import com.example.entity.Appointment;
import com.example.entity.SalonService;
import com.example.repository.AppointmentRepository;
import com.example.repository.SalonServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final SalonServiceRepository salonServiceRepository;

    // Yeni bir randevu oluştur
    // Yeni bir randevu oluştur
    public Appointment createAppointment(Appointment appointment) {
        // Hizmet adını kontrol etmeden doğrudan kaydet
        if (appointment.getSalonServiceName() == null || appointment.getSalonServiceName().isEmpty()) {
            throw new RuntimeException("Hizmet adı eksik!");
        }

        // Randevuyu kaydet ve döndür
        return appointmentRepository.save(appointment);
    }




    // Tüm randevuları getir
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }




    // Belirli bir müşterinin randevularını getir
    public List<Appointment> getAppointmentsByCustomer(String customerName) {
        return appointmentRepository.findByCustomerName(customerName);
    }

    // Randevuyu iptal et
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}
