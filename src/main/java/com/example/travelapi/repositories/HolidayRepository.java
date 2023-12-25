package com.example.travelapi.repositories;

import com.example.travelapi.entities.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface HolidayRepository extends JpaRepository<Holiday,Long> {

}
