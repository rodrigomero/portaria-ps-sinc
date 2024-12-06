package com.mero.portaria.config;

import com.mero.portaria.domain.model.*;
import com.mero.portaria.domain.model.enums.CarTypeEnum;
import com.mero.portaria.domain.model.enums.InspectionTypeEnum;
import com.mero.portaria.domain.model.enums.RoleEnum;
import com.mero.portaria.domain.model.enums.StatusEnum;
import com.mero.portaria.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDateTime;

@Profile("local")
@Configuration
public class BdInit {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private StaffRepository staffRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private InspectionRepository inspectionRepository;
    @Autowired
    private InspectionDetailsRepository inspectionDetailsRepository;

    @Bean
    public Boolean startDB() {

        Company company = new Company(null, "TechTransport Ltd", "12345678000199", "+5511999999999", "Av. Paulista, 1234, São Paulo, SP", "contact@techtransport.com", null);
        companyRepository.save(company);

        Staff staff1 = new Staff(null, "john.inspector@example.com", "123", RoleEnum.INSPETOR, "John Inspector", null, null);
        Staff staff2 = new Staff(null, "jjane.admin@example.com", "123", RoleEnum.GERENTE, "Jane Inspector", null, null);
        Staff staff3 = new Staff(null, "moto.admin@example.com", "123", RoleEnum.MOTORISTA, "Joao Motorista", null, null);
        Staff staff4 = new Staff(null, "moto2.admin@example.com", "123", RoleEnum.MOTORISTA, "Joao2 Motorista", null, null);
        staffRepository.save(staff1);
        staffRepository.save(staff2);
        staffRepository.save(staff3);
        staffRepository.save(staff4);

        Car car1 = new Car(null, CarTypeEnum.COMUM, "Toyota", "RAV4", 2022, "Blue", "XYZ-1234", LocalDateTime.now().minusMonths(1), StatusEnum.DISPONIVEL);
        Car car2 = new Car(null, CarTypeEnum.CARGA, "Honda", "Civic", 2021, "Red", "ABC-5678", LocalDateTime.now().minusMonths(2), StatusEnum.INDISPONIVEL);
        carRepository.save(car1);
        carRepository.save(car2);

        Driver driver1 = new Driver(null, 24, "33424235", car1, staff3, company);
        Driver driver2 = new Driver(null, 25, "44223435", null, staff4, company);
        driverRepository.save(driver1);
        driverRepository.save(driver2);

        Inspection inspection1 = new Inspection(null, InspectionTypeEnum.ENTRADA, LocalDateTime.now().minusDays(1), car1, null, driver1, staff1);
        Inspection inspection2 = new Inspection(null, InspectionTypeEnum.SAIDA, LocalDateTime.now(), car1, null, driver1, staff1);
        inspectionRepository.save(inspection1);
        inspectionRepository.save(inspection2);


        InspectionDetails inspectionDetails1 = new InspectionDetails(null, true, true, true, false, true, true, true, true, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, false, true, true, true, inspection1);
        InspectionDetails inspectionDetails2 = new InspectionDetails(null, true, false, true, true, true, false, true, true, false, true, true, false, true, false, true, false, true, true, true, false, true, true, true, true, true, false, true, inspection2);
        inspectionDetailsRepository.save(inspectionDetails1);
        inspectionDetailsRepository.save(inspectionDetails2);


        return Boolean.TRUE;
    }

}