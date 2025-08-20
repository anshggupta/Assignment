package com.MapMyTour.Assignment.dto;

import java.math.BigDecimal;

public record TourPackageResponse(
        Long id,
        String image,
        Integer discountInPercentage,
        String title,
        String description,
        String duration,
        BigDecimal actualPrice,
        BigDecimal discountedPrice,
        String currency,
        String location
) {}
