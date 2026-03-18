package com.kodilla.hibernate.manytomany.repository;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
