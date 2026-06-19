package za.ac.cput.domain;
import java.time.LocalDate;
import java.util.Objects;



/*
 * Class Name: Customer
 * Description: Customer CarRentSystem class
 * Author: Qhubekani Shandu (231316267)
 * Date: 20 June 2026
 */

public class Customer {

        private final String customerId;
        private final String fullName;
        private final String email;
        private final String phoneNumber;
        private final String driverLicenseNumber;
        private final LocalDate dateOfBirth;
        private final String address;
        private final NextOfKin nextOfKin;

        private Customer(Builder builder) {
            this.customerId = builder.customerId;
            this.fullName = builder.fullName;
            this.email = builder.email;
            this.phoneNumber = builder.phoneNumber;
            this.driverLicenseNumber = builder.driverLicenseNumber;
            this.dateOfBirth = builder.dateOfBirth;
            this.address = builder.address;
            this.nextOfKin = builder.nextOfKin;
        }

        public String getCustomerId() { return customerId; }
        public String getFullName() { return fullName; }
        public String getEmail() { return email; }
        public String getPhoneNumber() { return phoneNumber; }
        public String getDriverLicenseNumber() { return driverLicenseNumber; }
        public LocalDate getDateOfBirth() { return dateOfBirth; }
        public String getAddress() { return address; }
        public NextOfKin getNextOfKin() { return nextOfKin; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Objects.equals(customerId, customer.customerId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(customerId);
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerId='" + customerId + '\'' +
                    ", fullName='" + fullName + '\'' +
                    ", email='" + email + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", driverLicenseNumber='" + driverLicenseNumber + '\'' +
                    ", dateOfBirth=" + dateOfBirth +
                    ", address='" + address + '\'' +
                    ", nextOfKin=" + nextOfKin +
                    '}';
        }

        public static class Builder {
            private String customerId;
            private String fullName;
            private String email;
            private String phoneNumber;
            private String driverLicenseNumber;
            private LocalDate dateOfBirth;
            private String address;
            private NextOfKin nextOfKin;

            public Builder setCustomerId(String customerId) {
                this.customerId = customerId;
                return this;
            }

            public Builder setFullName(String fullName) {
                this.fullName = fullName;
                return this;
            }

            public Builder setEmail(String email) {
                this.email = email;
                return this;
            }

            public Builder setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
                return this;
            }

            public Builder setDriverLicenseNumber(String driverLicenseNumber) {
                this.driverLicenseNumber = driverLicenseNumber;
                return this;
            }

            public Builder setDateOfBirth(LocalDate dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
                return this;
            }

            public Builder setAddress(String address) {
                this.address = address;
                return this;
            }

            public Builder setNextOfKin(NextOfKin nextOfKin) {
                this.nextOfKin = nextOfKin;
                return this;
            }

            public Builder copy(Customer customer) {
                this.customerId = customer.customerId;
                this.fullName = customer.fullName;
                this.email = customer.email;
                this.phoneNumber = customer.phoneNumber;
                this.driverLicenseNumber = customer.driverLicenseNumber;
                this.dateOfBirth = customer.dateOfBirth;
                this.address = customer.address;
                this.nextOfKin = customer.nextOfKin;
                return this;
            }

            public Customer build() {
                return new Customer(this);
            }
        }
    }

