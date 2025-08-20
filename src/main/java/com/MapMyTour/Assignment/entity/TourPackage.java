package com.MapMyTour.Assignment.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tour_packages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TourPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1024)
    private String imageUrl;           // S3 or external URL

    private Integer discountPercent;   // e.g., 17

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String duration;           // e.g., 14Days/13Nights

    @Column(precision = 12, scale = 2)
    private BigDecimal actualPrice;    // numeric price

    @Column(precision = 12, scale = 2)
    private BigDecimal discountedPrice;

    private String currency;           // e.g., USD, INR

    private String location;           // e.g., Leh
}
