package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.MaintenanceRecord;
import za.ac.cput.service.MaintenanceRecordService;

import java.util.List;

/*
 * Class Name: MaintenanceRecordController
 * Description: REST Controller for MaintenanceRecord
 * Author: Alphonsine Ningabiye (230426581)
 * Date: 23 August 2026
 */

@RestController
@RequestMapping("/maintenanceRecord")
public class MaintenanceRecordController {

    private MaintenanceRecordService maintenanceRecordService;

    @Autowired
    public MaintenanceRecordController(
            MaintenanceRecordService maintenanceRecordService) {
        this.maintenanceRecordService = maintenanceRecordService;
    }

    @PostMapping("/create")
    public MaintenanceRecord create(
            @RequestBody MaintenanceRecord maintenanceRecord) {
        return maintenanceRecordService.create(maintenanceRecord);
    }

    @GetMapping("/read/{recordId}")
    public MaintenanceRecord read(
            @PathVariable("recordId") String recordId) {
        return maintenanceRecordService.read(recordId);
    }

    @PutMapping("/update")
    public MaintenanceRecord update(
            @RequestBody MaintenanceRecord maintenanceRecord) {
        return maintenanceRecordService.update(maintenanceRecord);
    }

    @DeleteMapping("/delete/{recordId}")
    public boolean delete(
            @PathVariable("recordId") String recordId) {
        return maintenanceRecordService.delete(recordId);
    }

    @GetMapping("/getAll")
    public List<MaintenanceRecord> getAll() {
        return maintenanceRecordService.findAll();
    }
}