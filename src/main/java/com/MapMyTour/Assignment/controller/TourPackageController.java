package com.MapMyTour.Assignment.controller;

import com.MapMyTour.Assignment.dto.TourPackageRequest;
import com.MapMyTour.Assignment.dto.TourPackageResponse;
import com.MapMyTour.Assignment.service.TourPackageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
@RequiredArgsConstructor
public class TourPackageController {

    private final TourPackageService service;

    // 1) Create Tour Package
    @PostMapping
    public TourPackageResponse create(@Valid @RequestBody TourPackageRequest request) {
        return service.create(request);
    }

    // 2) List All Packages (with optional location= query)
    @GetMapping
    public List<TourPackageResponse> list(@RequestParam(value = "location", required = false) String location) {
        return service.list(location);
    }

    // 3) Get Package by ID
    @GetMapping("/{id}")
    public TourPackageResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    // Optional: Upload/replace image for a tour and store on S3 or other storage
    @PostMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public TourPackageResponse uploadImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        return service.uploadImage(id, file);
    }

}
