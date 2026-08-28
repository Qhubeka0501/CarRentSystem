package za.ac.cput.service;

import za.ac.cput.domain.Register;

import java.util.List;

public interface RegisterService {

    Register create(Register register);

    Register read(String registerId);

    Register update(Register register);

    boolean delete(String registerId);

    List<Register> findAll();
}