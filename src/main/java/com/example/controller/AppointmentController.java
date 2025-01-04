package com.example.controller;

import com.example.entity.Appointment;
import com.example.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    // Yeni bir randevu oluştur
    @PostMapping("/create") // http://localhost:8080/api/appointments/create + POST
    public ResponseEntity<String> createAppointment(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.createAppointment(appointment);
        return ResponseEntity.ok("Randevunuz başarıyla oluşturuldu! Müşteri: "
                + savedAppointment.getCustomerName() + ", Tarih: "
                + savedAppointment.getAppointmentDate() + ", Hizmet: "
                + savedAppointment.getSalonService().getName() + ", Fiyat: "
                + savedAppointment.getPrice());
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
