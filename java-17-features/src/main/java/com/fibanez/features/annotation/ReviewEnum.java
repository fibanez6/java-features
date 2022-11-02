package com.fibanez.features.annotation;

public @interface ReviewEnum {
    ReviewStatus status() default ReviewStatus.PENDING;
    String comments() default "";
    // ReviewStatus enum is a member of the Review
    // annotation type
    public enum ReviewStatus {PENDING, FAILED, PASSED,
        PASSEDWITHCHANGES};
}
