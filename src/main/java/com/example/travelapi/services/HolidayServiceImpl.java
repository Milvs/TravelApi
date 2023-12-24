package com.example.travelapi.services;

import com.example.travelapi.dtos.CreateHolidayDTO;
import com.example.travelapi.dtos.ResponseHolidayDTO;
import com.example.travelapi.dtos.UpdateHolidayDTO;
import com.example.travelapi.entities.Holiday;
import com.example.travelapi.entities.Location;
import com.example.travelapi.repositories.HolidayRepository;
import com.example.travelapi.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void deleteHolidayById(Long id) {

    }

    @Override
    public List<ResponseHolidayDTO> getAllHolidays() {
        return null;
    }

    @Override
    public ResponseHolidayDTO getHolidayById(Long id) {
        return null;
    }

    @Override
    public ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateHolidayDTO) {
        return null;
    }
}



