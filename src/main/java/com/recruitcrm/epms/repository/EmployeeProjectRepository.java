package com.recruitcrm.epms.repository;
import com.recruitcrm.epms.model.EmployeeProject;
import com.recruitcrm.epms.model.EmployeeProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeProjectRepository
        extends JpaRepository<EmployeeProject, EmployeeProjectId> {
}