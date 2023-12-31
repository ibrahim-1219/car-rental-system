package com.global.controller;

import com.global.entity.Booking;
import com.global.error.CustomResponse;
import com.global.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/booking")
@CrossOrigin
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public ResponseEntity<?> findAll()
    {
        return ResponseEntity.ok(new CustomResponse(bookingService.findAll()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(new CustomResponse(bookingService.findById(id)));
    }
    @PostMapping("/add")
    public ResponseEntity<?> addBooking(@RequestBody Booking booking){
        return ResponseEntity.ok(new CustomResponse(bookingService.addBooking(booking)));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id)
    {
        return ResponseEntity.ok(new CustomResponse(bookingService.deleteById(id)));
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/available-cars")
    public ResponseEntity<?> findAvailableCars(@RequestParam String pickUpLocation,
                                                @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime startDateTime ,
                                               @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime endDateTime )
    {
        return ResponseEntity.ok(new CustomResponse(bookingService.findAvailableCars(pickUpLocation,startDateTime,endDateTime)));
    }

}