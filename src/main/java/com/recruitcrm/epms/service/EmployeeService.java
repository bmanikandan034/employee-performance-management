package com.recruitcrm.epms.service;

import com.recruitcrm.epms.model.Employee;
import com.recruitcrm.epms.repository.EmployeeRepository;
import com.recruitcrm.epms.specification.EmployeeSpecification;
import com.recruitcrm.epms.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;

	public List<Employee> getEmployees(Integer score, LocalDate reviewDate, List<String> departments,
			List<String> projects) {
		return employeeRepository.findAll(EmployeeSpecification.withFilters(score, reviewDate, departments, projects));
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
	}
}