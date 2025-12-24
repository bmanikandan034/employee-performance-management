package com.recruitcrm.epms.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.recruitcrm.epms.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {

	@EntityGraph(attributePaths = { "department", "manager", "employeeProjects.project" })
	Page<Employee> findAll(Specification<Employee> spec, Pageable pageable);

}
