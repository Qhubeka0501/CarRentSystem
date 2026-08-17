package za.ac.cput.factory;

/* Class Name: Review.java
 *Description: Review CarRentSystem Class
 * Author: Alphonsine Ningabiye(230426581)
 * Date: 28 June 2026
 */

import za.ac.cput.domain.MaintenanceRecord;

import java.time.LocalDate;

public class MaintenanceRecordFactory {

    public static MaintenanceRecord createMaintenanceRecord(
            String vehicleId,
            LocalDate date,
            String description,
            double cost,
            String technicianName) {

        String recordId = generateRecordId();

        return new MaintenanceRecord.Builder()
                .setRecordId(recordId)
                .setVehicleId(vehicleId)
                .setDate(date)
                .setDescription(description)
                .setCost(cost)
                .setTechnicianName(technicianName)
                .build();
    }

    private static String generateRecordId() {
        return "MR" + System.currentTimeMillis();
    }

    public static MaintenanceRecord createMaintenanceRecord(String m001, String oilChange, String date, double v) {
        return null;
    }
}