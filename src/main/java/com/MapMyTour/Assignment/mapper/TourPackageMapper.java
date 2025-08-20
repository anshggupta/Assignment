package com.MapMyTour.Assignment.mapper;

import com.MapMyTour.Assignment.dto.TourPackageRequest;
import com.MapMyTour.Assignment.dto.TourPackageResponse;
import com.MapMyTour.Assignment.entity.TourPackage;

import java.math.BigDecimal;

public class TourPackageMapper {

    public static TourPackage toEntity(TourPackageRequest req) {
        return TourPackage.builder()
                .imageUrl(req.image())
                .discountPercent(parsePercent(req.discountInPercentage()))
                .title(req.title())
                .description(req.description())
                .duration(req.duration())
                .actualPrice(parseMoney(req.actualPrice()))
                .discountedPrice(parseMoney(req.discountedPrice()))
                .currency(req.currency())
                .location(req.location())
                .build();
    }

    public static TourPackageResponse toResponse(TourPackage t) {
        return new TourPackageResponse(
                t.getId(),
                t.getImageUrl(),
                t.getDiscountPercent(),
                t.getTitle(),
                t.getDescription(),
                t.getDuration(),
                t.getActualPrice(),
                t.getDiscountedPrice(),
                t.getCurrency(),
                t.getLocation()
        );
    }

    private static Integer parsePercent(String s) {
        if (s == null) return null;
        String cleaned = s.trim().replace("%", "");
        return Integer.parseInt(cleaned);
    }

    private static BigDecimal parseMoney(String s) {
        if (s == null) return null;
        String cleaned = s.trim().replaceAll("[$,]", "");
        return new BigDecimal(cleaned);
    }
}

