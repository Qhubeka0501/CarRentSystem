package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Login;
import za.ac.cput.repository.LoginRepository;

import java.util.List;
import java.util.Optional;

/*
 * Class Name: LoginServiceImpl
 * Description: Login service implementation
 * Author: Alphonsine Ningabiye (230426581)
 * Date: August 2026
 */

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository repository;

    public LoginServiceImpl(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public Login create(Login login) {
        return repository.save(login);
    }

    @Override
    public Login read(String loginId) {
        return repository.findById(loginId).orElse(null);
    }

    @Override
    public Login update(Login login) {
        return repository.save(login);
    }

    @Override
    public boolean delete(String loginId) {
        if (repository.existsById(loginId)) {
            repository.deleteById(loginId);
            return true;
        }

        return false;
    }

    @Override
    public List<Login> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean login(String email, String password) {

        Optional<Login> login = repository.findByEmail(email);

        if (login.isPresent()) {
            return login.get().getPassword().equals(password);
        }

        return false;
    }
}