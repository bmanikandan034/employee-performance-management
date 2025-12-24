package com.recruitcrm.epms.dto;

import com.recruitcrm.epms.model.Employee;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String department;

    public static EmployeeResponseDTO from(Employee employee) {
        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment().getName()
        );
    }
}