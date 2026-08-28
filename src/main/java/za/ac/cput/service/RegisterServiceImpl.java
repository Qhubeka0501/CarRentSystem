package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Register;
import za.ac.cput.repository.RegisterRepository;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository repository;

    public RegisterServiceImpl(RegisterRepository repository) {
        this.repository = repository;
    }

    @Override
    public Register create(Register register) {
        return repository.save(register);
    }

    @Override
    public Register read(String registerId) {
        return repository.findById(registerId).orElse(null);
    }

    @Override
    public Register update(Register register) {
        return repository.save(register);
    }

    @Override
    public boolean delete(String registerId) {
        if (repository.existsById(registerId)) {
            repository.deleteById(registerId);
            return true;
        }

        return false;
    }

    @Override
    public List<Register> findAll() {
        return repository.findAll();
    }
}