package com.recruitcrm.epms.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recruitcrm.epms.dto.EmployeeDetailDTO;
import com.recruitcrm.epms.dto.EmployeeResponseDTO;
import com.recruitcrm.epms.model.Employee;
import com.recruitcrm.epms.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	public List<EmployeeResponseDTO> getEmployees(@RequestParam(required = false) Integer score,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reviewDate,
			@RequestParam(required = false) List<String> departments,
			@RequestParam(required = false) List<String> projects) {
		return employeeService.getEmployees(score, reviewDate, departments, projects).stream()
				.map(EmployeeResponseDTO::from).toList();
	}

	@GetMapping("/id")
	public EmployeeDetailDTO getEmployee(@RequestParam Long id) {
		Employee employee = employeeService.getEmployeeById(id);
		return EmployeeDetailDTO.from(employee);
	}

}