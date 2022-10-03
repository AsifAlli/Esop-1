package com.java.esop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.esop.entity.Employee;

/**
 * @author MURALI SANKAR
 * Interface Name : EmployeeRepository
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
