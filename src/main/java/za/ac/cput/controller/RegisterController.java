package za.ac.cput.controller;

import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Register;
import za.ac.cput.service.RegisterService;

import java.util.List;

/*
 * Class Name: RegisterController
 * Description: REST Controller for Register
 * Author: Alphonsine Ningabiye (230426581)
 * Date: 28 August 2026
 */

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/create")
    public Register create(@RequestBody Register register) {
        return registerService.create(register);
    }

    @GetMapping("/read/{registerId}")
    public Register read(@PathVariable String registerId) {
        return registerService.read(registerId);
    }

    @PutMapping("/update")
    public Register update(@RequestBody Register register) {
        return registerService.update(register);
    }

    @DeleteMapping("/delete/{registerId}")
    public boolean delete(@PathVariable String registerId) {
        return registerService.delete(registerId);
    }

    @GetMapping("/getAll")
    public List<Register> getAll() {
        return registerService.findAll();
    }
}