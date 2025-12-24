package com.recruitcrm.epms.dto;
import com.recruitcrm.epms.model.PerformanceReview;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerformanceReviewDTO {

    private LocalDate reviewDate;
    private Integer score;
    private String reviewComments;

    public static PerformanceReviewDTO from(PerformanceReview review) {
        return new PerformanceReviewDTO(
                review.getReviewDate(),
                review.getScore(),
                review.getReviewComments()
        );
    }
}