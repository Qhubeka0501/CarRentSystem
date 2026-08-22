package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Notification;
import za.ac.cput.service.NotificationService;

import java.util.List;

/*  Class Name: NotificationController

     Description: NotificationController CarRentSystem class

     Author: Lucky July Twala (231242840)

     Date: 12 July 2026 */
@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/create")
    public Notification create(@RequestBody Notification notification) {
        return notificationService.create(notification);
    }

    @GetMapping("/read/{notificationId}")
    public Notification read(@PathVariable("notificationId") String notificationId) {
        return notificationService.read(notificationId);
    }

    @PutMapping("/update")
    public Notification update(@RequestBody Notification notification) {
        return notificationService.update(notification);
    }

    @DeleteMapping("/delete/{notificationId}")
    public void delete(@PathVariable("notificationId") String notificationId) {
        notificationService.delete(notificationId);
    }

    @GetMapping("/getAll")
    public List<Notification> getAll() {
        return notificationService.findAll();
    }

    @GetMapping("/customer/{customerId}")
    public List<Notification> getByCustomerId(@PathVariable("customerId") String customerId) {
        return notificationService.findByCustomerId(customerId);
    }
}
