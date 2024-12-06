package com.mero.portaria.domain.repository;

import com.mero.portaria.domain.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findByName(String name);
}
