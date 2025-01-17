package com.example.controller;

import com.example.entity.Appointment;
import com.example.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    // Yeni bir randevu oluştur
    @PostMapping("/create")
    public ResponseEntity<?> createAppointment(@RequestBody Appointment appointment) {
        System.out.println("Gelen JSON: " + appointment); // Gelen JSON'u kontrol ediyoruz.
        try {
            Appointment savedAppointment = appointmentService.createAppointment(appointment);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Randevunuz başarıyla oluşturuldu! Müşteri: "
                    + savedAppointment.getCustomerName() + ", Tarih: "
                    + savedAppointment.getAppointmentDate() + ", Hizmet: "
                    + savedAppointment.getSalonServiceName() + ", Fiyat: "
                    + savedAppointment.getPrice());
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            System.out.println("Hata: " + e.getMessage()); // Hata detaylarını loglayın
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }





    // Tüm randevuları getir
    @GetMapping("/all") // http://localhost:8080/api/appointments/all + GET
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }



    // Belirli bir müşterinin randevularını getir
    @GetMapping("/customer") // http://localhost:8080/api/appointments/customer + GET
    public List<Appointment> getAppointments(@RequestParam String customerName) {
        return appointmentService.getAppointmentsByCustomer(customerName);
    }


    // Randevuyu iptal et
    @DeleteMapping("/cancel/{id}") // http://localhost:8080/api/appointments/cancel/{id} + DELETE
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return "Randevu başarıyla iptal edildi.";
    }
}
