package com.recruitcrm.epms.specification;

import com.recruitcrm.epms.model.*;
import jakarta.persistence.criteria.*;
import lombok.NoArgsConstructor;

import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class EmployeeSpecification {
	public static Specification<Employee> withFilters(Integer score, LocalDate reviewDate, List<String> departments,
			List<String> projects) {
		return (Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {

			List<Predicate> predicates = new ArrayList<>();

			if (query.getResultType() != Long.class) {

				root.fetch("department", JoinType.LEFT);
				root.fetch("manager", JoinType.LEFT);

				Fetch<Employee, EmployeeProject> epFetch = root.fetch("employeeProjects", JoinType.LEFT);
				epFetch.fetch("project", JoinType.LEFT);

				root.fetch("performanceReviews", JoinType.LEFT);
			}

			if (score != null || reviewDate != null) {

				Join<Employee, PerformanceReview> reviewJoin = root.join("performanceReviews", JoinType.LEFT);

				if (score != null) {
					predicates.add(cb.equal(reviewJoin.get("score"), score));
				}

				if (reviewDate != null) {
					predicates.add(cb.equal(reviewJoin.get("reviewDate"), reviewDate));
				}
			}

			if (departments != null && !departments.isEmpty()) {

				Join<Employee, Department> departmentJoin = root.join("department", JoinType.INNER);

				predicates.add(departmentJoin.get("name").in(departments));
			}

			if (projects != null && !projects.isEmpty()) {

				Join<Employee, EmployeeProject> epJoin = root.join("employeeProjects", JoinType.INNER);

				Join<EmployeeProject, Project> projectJoin = epJoin.join("project", JoinType.INNER);

				predicates.add(projectJoin.get("name").in(projects));
			}

			query.distinct(true);

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}

}