package com.MapMyTour.Assignment.service.storage;

import org.springframework.web.multipart.MultipartFile;

public interface ImageStorageService {
    /**
     * Store the given image and return a public URL.
     */
    String store(MultipartFile file, String keyPrefix);

}
