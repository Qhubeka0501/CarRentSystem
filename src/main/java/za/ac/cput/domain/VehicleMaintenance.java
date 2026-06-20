package za.ac.cput.domain;


import jakarta.persistence.*;
import java.time.LocalDate;
/*
 VehicleMaintenance.java
 Entity class for vehicle service records
 Author: Alphonsine Ningabiye
 Date: 21 June 2026
*/

@Entity
@Table(name="vehicle_maintenance")
    public class VehicleMaintenance {
    @Id

    private String maintenanceId;

    private LocalDate maintenanceDate;

    private String type;

    private double cost;

    private String mechanicName;

    private LocalDate nextDueDate;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;


    protected VehicleMaintenance() {
    }


    private VehicleMaintenance(Builder builder) {

        this.maintenanceId = builder.maintenanceId;
        this.maintenanceDate = builder.maintenanceDate;
        this.type = builder.type;
        this.cost = builder.cost;
        this.mechanicName = builder.mechanicName;
        this.nextDueDate = builder.nextDueDate;
        this.vehicle = builder.vehicle;

    }


    public String getMaintenanceId() {
        return maintenanceId;
    }


    public LocalDate getMaintenanceDate() {
        return maintenanceDate;
    }


    public String getType() {
        return type;
    }


    public double getCost() {
        return cost;
    }


    public String getMechanicName() {
        return mechanicName;
    }


    public LocalDate getNextDueDate() {
        return nextDueDate;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }


    public static class Builder {


        private String maintenanceId;

        private LocalDate maintenanceDate;

        private String type;

        private double cost;

        private String mechanicName;

        private LocalDate nextDueDate;

        private Vehicle vehicle;


        public Builder setMaintenanceId(String maintenanceId) {
            this.maintenanceId = maintenanceId;
            return this;
        }


        public Builder setMaintenanceDate(LocalDate maintenanceDate) {
            this.maintenanceDate = maintenanceDate;
            return this;
        }


        public Builder setType(String type) {
            this.type = type;
            return this;
        }


        public Builder setCost(double cost) {
            this.cost = cost;
            return this;
        }


        public Builder setMechanicName(String mechanicName) {
            this.mechanicName = mechanicName;
            return this;
        }


        public Builder setNextDueDate(LocalDate nextDueDate) {
            this.nextDueDate = nextDueDate;
            return this;
        }


        public Builder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }


        public VehicleMaintenance build() {

            return new VehicleMaintenance(this);

        }

    }

}

