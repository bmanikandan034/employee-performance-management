package com.recruitcrm.epms.model;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeProjectId implements Serializable {

    private Long employeeId;
    private Long projectId;
}