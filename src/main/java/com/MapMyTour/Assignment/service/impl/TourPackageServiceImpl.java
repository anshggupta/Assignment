package com.MapMyTour.Assignment.service.impl;

import com.MapMyTour.Assignment.dto.TourPackageRequest;
import com.MapMyTour.Assignment.dto.TourPackageResponse;
import com.MapMyTour.Assignment.entity.TourPackage;
import com.MapMyTour.Assignment.exception.ResourceNotFoundException;
import com.MapMyTour.Assignment.mapper.TourPackageMapper;
import com.MapMyTour.Assignment.repository.TourPackageRepository;
import com.MapMyTour.Assignment.service.TourPackageService;
import com.MapMyTour.Assignment.service.storage.ImageStorageService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TourPackageServiceImpl implements TourPackageService {

    private final TourPackageRepository repo;
    private final ImageStorageService imageStorageService; // can be a no-op local impl if S3 not configured

    @Override
    public TourPackageResponse create(TourPackageRequest request) {
        TourPackage toSave = TourPackageMapper.toEntity(request);
        TourPackage saved = repo.save(toSave);
        return TourPackageMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TourPackageResponse> list(String location) {
        var results = (location == null || location.isBlank())
                ? repo.findAll()
                : repo.findByLocationIgnoreCaseContaining(location);
        return results.stream().map(TourPackageMapper::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public TourPackageResponse getById(Long id) {
        TourPackage t = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TourPackage not found: " + id));
        return TourPackageMapper.toResponse(t);
    }

    @Override
    public TourPackageResponse uploadImage(Long id, MultipartFile file) {
        TourPackage t = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TourPackage not found: " + id));
        String url = imageStorageService.store(file, "tours/" + id + "/");
        t.setImageUrl(url);
        return TourPackageMapper.toResponse(t);
    }
}

