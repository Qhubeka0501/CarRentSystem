package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

/*
 * Class Name: Register
 * Description: Register CarRentSystem class
 * Author: Alphonsine Ningabiye (230426581)
 * Date: 28 August 2026
 */

@Entity
public class Register {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String registerId;

    private String name;
    private String email;
    private String password;
    private String role;
    private boolean active;

    protected Register() {
    }

    private Register(Builder builder) {
        this.registerId = builder.registerId;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
        this.active = builder.active;
    }

    public String getRegisterId() {
        return registerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Register register = (Register) o;
        return Objects.equals(registerId, register.registerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registerId);
    }

    @Override
    public String toString() {
        return "Register{" +
                "registerId='" + registerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                '}';
    }

    public static class Builder {

        private String registerId;
        private String name;
        private String email;
        private String password;
        private String role;
        private boolean active;

        public Builder setRegisterId(String registerId) {
            this.registerId = registerId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setActive(boolean active) {
            this.active = active;
            return this;
        }

        public Builder copy(Register register) {
            this.registerId = register.registerId;
            this.name = register.name;
            this.email = register.email;
            this.password = register.password;
            this.role = register.role;
            this.active = register.active;
            return this;
        }

        public Register build() {
            return new Register(this);
        }
    }
}