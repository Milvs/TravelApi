package com.example.travelapi.services;

import com.example.travelapi.dtos.CreateHolidayDTO;
import com.example.travelapi.dtos.ResponseHolidayDTO;
import com.example.travelapi.dtos.UpdateHolidayDTO;
import jakarta.persistence.NamedEntityGraph;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.Date;
import java.util.List;


public interface HolidayService {

    ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO);

    void deleteHolidayById(Long id);

    List<ResponseHolidayDTO> getAllHolidaysByFilters(String location, Date startDate, Integer duration);

    ResponseHolidayDTO getHolidayById(Long id);

    ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO);

}
