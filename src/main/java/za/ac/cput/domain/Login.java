package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/*
 * Class Name: Login
 * Description: Login entity for CarRentSystem
 * Author: Alphonsine Ningabiye (230426581)
 * Date: August 2026
 */

@Entity
public class Login {

    @Id
    private String loginId;

    private String email;
    private String password;

    protected Login() {
    }

    private Login(Builder builder) {
        this.loginId = builder.loginId;
        this.email = builder.email;
        this.password = builder.password;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginId='" + loginId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder {

        private String loginId;
        private String email;
        private String password;

        public Builder setLoginId(String loginId) {
            this.loginId = loginId;
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

        public Builder copy(Login login) {
            this.loginId = login.loginId;
            this.email = login.email;
            this.password = login.password;
            return this;
        }

        public Login build() {
            return new Login(this);
        }
    }
}