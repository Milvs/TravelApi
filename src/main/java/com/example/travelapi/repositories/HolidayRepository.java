package com.example.travelapi.repositories;

import com.example.travelapi.entities.Holiday;
import com.example.travelapi.entities.Location;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday,Long> {
}
