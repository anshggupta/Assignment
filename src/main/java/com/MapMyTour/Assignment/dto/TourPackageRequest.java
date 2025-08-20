package com.MapMyTour.Assignment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record TourPackageRequest(
        String image,                  // may be null; could be set after S3 upload
        @Pattern(regexp = "^\\d+%$", message = "discountInPercentage must be like '17%'")
        String discountInPercentage,
        @NotBlank String title,
        @NotBlank String description,
        @NotBlank String duration,
        @NotBlank String actualPrice,      // accepts formats like "$1200" or "1200"
        @NotBlank String discountedPrice,  // accepts formats like "$1000" or "1000"
        @NotBlank String currency,         // e.g., USD / INR
        @NotBlank String location
) {}
