package com.MapMyTour.Assignment.repository;

import com.MapMyTour.Assignment.entity.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TourPackageRepository extends JpaRepository<TourPackage, Long> {
    List<TourPackage> findByLocationIgnoreCaseContaining(String location);

    @Query("SELECT t FROM TourPackage t WHERE (:location IS NULL OR LOWER(t.location) LIKE LOWER(CONCAT('%', :location, '%'))) ")
    List<TourPackage> search(@Param("location") String location);
}
