package com.global.controller;

import com.global.entity.Booking;
import com.global.error.CustomResponse;
import com.global.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

     @GetMapping("/all")
    public ResponseEntity<?> findAll()
     {
         return ResponseEntity.ok(new CustomResponse(bookingService.findAll()));
     }
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(Long id)
    {
        return ResponseEntity.ok(new CustomResponse(bookingService.findById(id)));
    }
    @PostMapping("/add")
    public ResponseEntity<?> addBooking(@RequestBody Booking booking){
         return ResponseEntity.ok(new CustomResponse(bookingService.addBooking(booking)));
    }
}
