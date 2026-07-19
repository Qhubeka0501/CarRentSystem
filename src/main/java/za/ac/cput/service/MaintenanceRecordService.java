package za.ac.cput.service;

import za.ac.cput.domain.MaintenanceRecord;

import java.util.List;

public interface MaintenanceRecordService extends IService<MaintenanceRecord, String> {
    List<MaintenanceRecord> findAll();
}