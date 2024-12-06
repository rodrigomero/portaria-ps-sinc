package com.mero.portaria.domain.repository;

import com.mero.portaria.domain.model.InspectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionDetailsRepository extends JpaRepository<InspectionDetails, Integer> {
}
