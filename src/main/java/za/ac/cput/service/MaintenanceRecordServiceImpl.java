package za.ac.cput.service;



import za.ac.cput.domain.MaintenanceRecord;

import java.util.HashMap;
import java.util.Map;

public class MaintenanceRecordServiceImpl implements MaintenanceRecordService {

    private static MaintenanceRecordService service = null;
    private final Map<String, MaintenanceRecord> maintenanceDB;

    private MaintenanceRecordServiceImpl() {
        maintenanceDB = new HashMap<>();
    }

    public static MaintenanceRecordService getService() {
        if (service == null) {
            service = new MaintenanceRecordServiceImpl();
        }
        return service;
    }

    @Override
    public MaintenanceRecord create(MaintenanceRecord maintenanceRecord) {
        maintenanceDB.put(maintenanceRecord.getRecordId(), maintenanceRecord);
        return maintenanceRecord;
    }

    @Override
    public MaintenanceRecord read(String recordId) {
        return maintenanceDB.get(recordId);
    }

    @Override
    public MaintenanceRecord update(MaintenanceRecord maintenanceRecord) {
        if (maintenanceDB.containsKey(maintenanceRecord.getRecordId())) {
            maintenanceDB.put(maintenanceRecord.getRecordId(), maintenanceRecord);
            return maintenanceRecord;
        }
        return null;
    }

    @Override
    public boolean delete(String recordId) {
        return maintenanceDB.remove(recordId) != null;
    }
}