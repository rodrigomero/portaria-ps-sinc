package com.mero.portaria.domain.repository;

import com.mero.portaria.domain.model.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository extends JpaRepository<Inspection, Integer> {
}
