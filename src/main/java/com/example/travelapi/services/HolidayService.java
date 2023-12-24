package com.example.travelapi.services;

import com.example.travelapi.dtos.CreateHolidayDTO;
import com.example.travelapi.dtos.ResponseHolidayDTO;
import com.example.travelapi.dtos.UpdateHolidayDTO;

import java.util.List;

public interface HolidayService {

    ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO);
     void deleteHolidayById(Long id);
     List<ResponseHolidayDTO> getAllHolidays();
     ResponseHolidayDTO getHolidayById(Long id);

     ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO);

}
