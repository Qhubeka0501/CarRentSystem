package za.ac.cput.factory;

import za.ac.cput.domain.Register;

/*
 * Class Name: RegisterFactory
 * Description: Factory for creating Register objects
 * Author: Alphonsine Ningabiye (230426581)
 * Date: 28 August 2026
 */

public class RegisterFactory {

    public static Register createRegister(
            String name,
            String email,
            String password,
            String role) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required");
        }

        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role is required");
        }

        return new Register.Builder()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .setRole(role)
                .setActive(true)
                .build();
    }
}