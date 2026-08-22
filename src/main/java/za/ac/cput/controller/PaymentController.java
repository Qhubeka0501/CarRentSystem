package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Payment;
import za.ac.cput.service.PaymentService;

import java.util.List;

/*  Class Name: PaymentController

     Description: PaymentController CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 12 July 2026 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/read/{paymentId}")
    public Payment read(@PathVariable("paymentId") String paymentId) {
        return paymentService.read(paymentId);
    }

    @PutMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return paymentService.update(payment);
    }

    @DeleteMapping("/delete/{paymentId}")
    public void delete(@PathVariable("paymentId") String paymentId) {
        paymentService.delete(paymentId);
    }

    @GetMapping("/getAll")
    public List<Payment> getAll() {
        return paymentService.findAll();
    }

    @GetMapping("/booking/{bookingId}")
    public List<Payment> getByBookingId(@PathVariable("bookingId") String bookingId) {
        return paymentService.findByBookingId(bookingId);
    }
}
