package za.ac.cput.factory;

import za.ac.cput.domain.Login;

/*
 * Class Name: LoginFactory
 * Description: Factory for creating Login objects
 * Author: Alphonsine Ningabiye (230426581)
 * Date: August 2026
 */

public class LoginFactory {

    public static Login createLogin(String email, String password) {

        if (email == null || email.trim().isEmpty()) {
            return null;
        }

        if (password == null || password.trim().isEmpty()) {
            return null;
        }

        String loginId = "LOG" + System.currentTimeMillis();

        return new Login.Builder()
                .setLoginId(loginId)
                .setEmail(email)
                .setPassword(password)
                .build();
    }
}