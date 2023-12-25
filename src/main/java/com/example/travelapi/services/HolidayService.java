package com.example.travelapi.services;

import com.example.travelapi.dtos.CreateHolidayDTO;
import com.example.travelapi.dtos.ResponseHolidayDTO;
import com.example.travelapi.dtos.UpdateHolidayDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface HolidayService {

    ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO);

    Boolean deleteHolidayById(Long id);

    List<ResponseHolidayDTO> getAllHolidays(Long location, Date startDate, int duration);

    ResponseHolidayDTO getHolidayById(Long id);

    ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO);

}
