package com.recruitcrm.epms.dto;

import com.recruitcrm.epms.model.Employee;
import lombok.*;

import java.util.Comparator;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailDTO {

	private Long id;
	private String name;
	private String email;
	private String department;
	private List<String> projects;
	private List<PerformanceReviewDTO> last3Reviews;

	public static EmployeeDetailDTO from(Employee employee) {

		return new EmployeeDetailDTO(employee.getId(), employee.getName(), employee.getEmail(),
				employee.getDepartment().getName(),
				employee.getEmployeeProjects().stream().map(ep -> ep.getProject().getName()).toList(),
				employee.getPerformanceReviews().stream()
						.sorted(Comparator.comparing(r -> r.getReviewDate(), Comparator.reverseOrder())).limit(3)
						.map(PerformanceReviewDTO::from).toList());
	}
}