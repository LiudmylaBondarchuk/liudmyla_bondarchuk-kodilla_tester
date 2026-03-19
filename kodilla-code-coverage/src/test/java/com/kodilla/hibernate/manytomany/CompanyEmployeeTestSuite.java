package com.kodilla.hibernate.manytomany;

import com.kodilla.hibernate.manytomany.repository.CompanyRepository;
import com.kodilla.hibernate.manytomany.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Tag;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Tag("integration")
class CompanyEmployeeTestSuite {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarkson = new Employee("Stephanie", "Clarkson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.addEmployee(johnSmith);
        dataMasters.addEmployee(stephanieClarkson);
        dataMasters.addEmployee(lindaKovalsky);
        greyMatter.addEmployee(johnSmith);
        greyMatter.addEmployee(lindaKovalsky);

        johnSmith.addCompany(softwareMachine);
        johnSmith.addCompany(greyMatter);
        stephanieClarkson.addCompany(dataMasters);
        lindaKovalsky.addCompany(dataMasters);
        lindaKovalsky.addCompany(greyMatter);

        //When
        companyRepository.save(softwareMachine);
        companyRepository.save(dataMasters);
        companyRepository.save(greyMatter);

        //Then
        Assertions.assertNotEquals(0, softwareMachine.getId());
        Assertions.assertNotEquals(0, dataMasters.getId());
        Assertions.assertNotEquals(0, greyMatter.getId());

        //CleanUp
        try {
            companyRepository.deleteById(softwareMachine.getId());
            companyRepository.deleteById(dataMasters.getId());
            companyRepository.deleteById(greyMatter.getId());
        } catch (Exception e) {
            System.err.println("Cleanup failed: " + e.getMessage());
        }
    }
}
