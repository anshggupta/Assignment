package com.MapMyTour.Assignment.exception;

import java.time.OffsetDateTime;
import java.util.List;

public record ApiError(
        String path,
        int status,
        String error,
        String message,
        OffsetDateTime timestamp,
        List<String> validationErrors
) {}
