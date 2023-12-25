package com.example.travelapi.services;

import com.example.travelapi.dtos.CreateHolidayDTO;
import com.example.travelapi.dtos.ResponseHolidayDTO;
import com.example.travelapi.dtos.UpdateHolidayDTO;
import com.example.travelapi.entities.Holiday;
import com.example.travelapi.entities.Location;
import com.example.travelapi.repositories.HolidayRepository;
import com.example.travelapi.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HolidayServiceImpl implements HolidayService{

    private final HolidayRepository holidayRepository;
    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;


    @Override
    public ResponseHolidayDTO createHoliday(CreateHolidayDTO createHolidayDTO) {
        Location location = locationRepository.findById(createHolidayDTO.getLocation()).orElseThrow();

        Holiday holiday = Holiday.builder().price(createHolidayDTO.getPrice())
                .title(createHolidayDTO.getTitle())
                .freeSlots(createHolidayDTO.getFreeSlots())
                .startDate(createHolidayDTO.getStartDate())
                .duration(createHolidayDTO.getDuration())
                .location(location)
                .build();

        holidayRepository.save(holiday);

        return modelMapper.map(holiday,ResponseHolidayDTO.class);

    }

    @Override
    public Boolean deleteHolidayById(Long id) {
        Holiday holiday = holidayRepository.findById(id).orElse(null);
        if (holiday!=null){
            holidayRepository.delete(holiday);
            return true;
        }
        return false;

    }

    @Override
    public List<ResponseHolidayDTO> getAllHolidays(Long location, Date startDate,int duration) {
        Location loc = locationRepository.findById(location).orElseThrow();
        List<Holiday> holidays = holidayRepository.findAll();
        return holidays.stream().map(h->modelMapper.map(h,ResponseHolidayDTO.class))
                .toList();
    }

    @Override
    public ResponseHolidayDTO getHolidayById(Long id) {
        Holiday holiday = holidayRepository.findById(id).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Holiday not found for id = %s", id);
            return new IllegalArgumentException(errorMessage);});
        return modelMapper.map(holiday, ResponseHolidayDTO.class);
    }

    @Override
    public ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHoliday) {
        Holiday holiday = holidayRepository.findById(updateHoliday.getId()).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Holiday not found for id = %s", updateHoliday.getId());
            return new IllegalArgumentException(errorMessage);});

        Location location = locationRepository.findById(updateHoliday.getLocation()).orElseThrow();
        holiday.setPrice(updateHoliday.getPrice());
        holiday.setDuration(updateHoliday.getDuration());
        holiday.setLocation(location);
        holiday.setStartDate(updateHoliday.getStartDate());
        holiday.setTitle(updateHoliday.getTitle());
        holidayRepository.save(holiday);

        return modelMapper.map(holiday,ResponseHolidayDTO.class);
    }
}



