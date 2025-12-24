package com.recruitcrm.epms.repository;
import com.recruitcrm.epms.model.PerformanceReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformanceReviewRepository
        extends JpaRepository<PerformanceReview, Long> {
}