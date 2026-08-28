package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Login;
import za.ac.cput.service.LoginService;

import java.util.List;

/*
 * Class Name: LoginController
 * Description: REST Controller for Login
 * Author: Alphonsine Ningabiye (230426581)
 * Date: August 2026
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/create")
    public Login create(@RequestBody Login login) {
        return loginService.create(login);
    }

    @GetMapping("/read/{loginId}")
    public Login read(@PathVariable("loginId") String loginId) {
        return loginService.read(loginId);
    }

    @PutMapping("/update")
    public Login update(@RequestBody Login login) {
        return loginService.update(login);
    }

    @DeleteMapping("/delete/{loginId}")
    public boolean delete(@PathVariable("loginId") String loginId) {
        return loginService.delete(loginId);
    }

    @GetMapping("/getAll")
    public List<Login> getAll() {
        return loginService.findAll();
    }

    @PostMapping("/authenticate")
    public boolean authenticate(
            @RequestParam String email,
            @RequestParam String password) {

        return loginService.login(email, password);
    }
}