package za.ac.cput.domain;

/* class Name: MaintenanceRecord.java
 *Description:MaintenanceRecord CarRentSystem class
 * Author: Alphonsine Ningabiye(230426581)
 * Date: 21 June 2026

 */

import java.time.LocalDate;

public class MaintenanceRecord {

    private String recordId;
    private String vehicleId;
    private LocalDate date;
    private String description;
    private double cost;
    private String technicianName;

    private MaintenanceRecord() {
    }

    private MaintenanceRecord(Builder builder) {
        this.recordId = builder.recordId;
        this.vehicleId = builder.vehicleId;
        this.date = builder.date;
        this.description = builder.description;
        this.cost = builder.cost;
        this.technicianName = builder.technicianName;
    }

    public String getRecordId() {
        return recordId;
    }
    public String getVehicleId() {
        return vehicleId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public String getTechnicianName() {
        return technicianName;
    }

    @Override
    public String toString() {
        return "MaintenanceRecord{" +
                "recordId='" + recordId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", technicianName='" + technicianName + '\'' +
                '}';
    }

    public static class Builder {

        private String recordId;
        private String vehicleId;
        private LocalDate date;
        private String description;
        private double cost;
        private String technicianName;

        public Builder setRecordId(String recordId) {
            this.recordId = recordId;
            return this;
        }
        public Builder setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
            return this;
        }
        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }
        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Builder setCost(double cost) {
            this.cost = cost;
            return this;
        }

        public Builder setTechnicianName(String technicianName) {
            this.technicianName = technicianName;
            return this;
        }

        public Builder copy(MaintenanceRecord maintenanceRecord) {
            this.recordId = maintenanceRecord.recordId;
            this.vehicleId = maintenanceRecord.vehicleId;
            this.date = maintenanceRecord.date;
            this.description = maintenanceRecord.description;
            this.cost = maintenanceRecord.cost;
            this.technicianName = maintenanceRecord.technicianName;
            return this;
        }

        public MaintenanceRecord build() {
            return new MaintenanceRecord(this);
        }
    }
}