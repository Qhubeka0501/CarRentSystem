package za.ac.cput.service;

import za.ac.cput.domain.Login;

import java.util.List;

public interface LoginService {

    Login create(Login login);

    Login read(String loginId);

    Login update(Login login);

    boolean delete(String loginId);

    List<Login> findAll();

    boolean login(String email, String password);
}