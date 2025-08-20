package com.MapMyTour.Assignment.service;

import com.MapMyTour.Assignment.dto.TourPackageRequest;
import com.MapMyTour.Assignment.dto.TourPackageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TourPackageService {
    TourPackageResponse create(TourPackageRequest request);
    List<TourPackageResponse> list(String location);
    TourPackageResponse getById(Long id);
    TourPackageResponse uploadImage(Long id, MultipartFile file);
}
