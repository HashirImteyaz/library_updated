package com.arvind.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arvind.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
