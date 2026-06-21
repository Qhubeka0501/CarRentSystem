package za.ac.cput.domain;

/*
 * Class Name: Customer
 * Description: Customer CarRentSystem class
 * Author: Qhubekani Shandu (231316267)
 * Date: 20 June 2026
 */

import java.util.Objects;

    public class Vehicle {
        private final String vehicleId;
        private final String licensePlate;
        private final String make;
        private final String model;
        private final int year;
        private final String color;
        private final double mileage;
        private final double dailyRate;
        private final double weeklyRate;
        private final VehicleStatus status;

        private Vehicle(Builder builder) {
            this.vehicleId = builder.vehicleId;
            this.licensePlate = builder.licensePlate;
            this.make = builder.make;
            this.model = builder.model;
            this.year = builder.year;
            this.color = builder.color;
            this.mileage = builder.mileage;
            this.dailyRate = builder.dailyRate;
            this.weeklyRate = builder.weeklyRate;
            this.status = builder.status;
        }

        public String getVehicleId() { return vehicleId; }
        public String getLicensePlate() { return licensePlate; }
        public String getMake() { return make; }
        public String getModel() { return model; }
        public int getYear() { return year; }
        public String getColor() { return color; }
        public double getMileage() { return mileage; }
        public double getDailyRate() { return dailyRate; }
        public double getWeeklyRate() { return weeklyRate; }
        public VehicleStatus getStatus() { return status; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vehicle vehicle = (Vehicle) o;
            return Objects.equals(vehicleId, vehicle.vehicleId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(vehicleId);
        }

        @Override
        public String toString() {
            return "Vehicle{" +
                    "vehicleId='" + vehicleId + '\'' +
                    ", licensePlate='" + licensePlate + '\'' +
                    ", make='" + make + '\'' +
                    ", model='" + model + '\'' +
                    ", year=" + year +
                    ", color='" + color + '\'' +
                    ", mileage=" + mileage +
                    ", dailyRate=" + dailyRate +
                    ", weeklyRate=" + weeklyRate +
                    ", status=" + status +
                    '}';
        }

        public static class Builder {
            private String vehicleId;
            private String licensePlate;
            private String make;
            private String model;
            private int year;
            private String color;
            private double mileage;
            private double dailyRate;
            private double weeklyRate;
            private VehicleStatus status;

            public Builder setVehicleId(String vehicleId) {
                this.vehicleId = vehicleId;
                return this;
            }

            public Builder setLicensePlate(String licensePlate) {
                this.licensePlate = licensePlate;
                return this;
            }

            public Builder setMake(String make) {
                this.make = make;
                return this;
            }

            public Builder setModel(String model) {
                this.model = model;
                return this;
            }

            public Builder setYear(int year) {
                this.year = year;
                return this;
            }

            public Builder setColor(String color) {
                this.color = color;
                return this;
            }

            public Builder setMileage(double mileage) {
                this.mileage = mileage;
                return this;
            }

            public Builder setDailyRate(double dailyRate) {
                this.dailyRate = dailyRate;
                return this;
            }

            public Builder setWeeklyRate(double weeklyRate) {
                this.weeklyRate = weeklyRate;
                return this;
            }

            public Builder setStatus(VehicleStatus status) {
                this.status = status;
                return this;
            }

            public Builder copy(Vehicle vehicle) {
                this.vehicleId = vehicle.vehicleId;
                this.licensePlate = vehicle.licensePlate;
                this.make = vehicle.make;
                this.model = vehicle.model;
                this.year = vehicle.year;
                this.color = vehicle.color;
                this.mileage = vehicle.mileage;
                this.dailyRate = vehicle.dailyRate;
                this.weeklyRate = vehicle.weeklyRate;
                this.status = vehicle.status;
                return this;
            }

            public Vehicle build() {
                return new Vehicle(this);
            }
        }
    }

