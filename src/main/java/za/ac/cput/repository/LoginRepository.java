package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Login;

import java.util.Optional;

/*
 * Class Name: LoginRepository
 * Description: Repository for Login
 * Author: Alphonsine Ningabiye (230426581)
 * Date: August 2026
 */

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

    Optional<Login> findByEmail(String email);
}