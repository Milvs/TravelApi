package com.example.travelapi.services;

import com.example.travelapi.dtos.CreateHolidayDTO;
import com.example.travelapi.dtos.ResponseHolidayDTO;
import com.example.travelapi.dtos.UpdateHolidayDTO;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface HolidayService {

    ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO);

    void deleteHolidayById(Long id);

    List<ResponseHolidayDTO> getAllHolidaysByFilters(String city,String country, Date startDate, Integer duration);

    ResponseHolidayDTO getHolidayById(Long id);

    ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO);

}
