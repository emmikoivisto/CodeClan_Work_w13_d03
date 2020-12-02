package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findByYear(Integer year);

    List<Whisky> findByDistilleryName(String distilleryName);
    List<Whisky> findByAge(Integer age);
    List<Whisky> findByDistilleryRegion(String distilleryRegion);
    List<Whisky> findByDistilleryNameAndAge(String distilleryName, Integer age);

}
