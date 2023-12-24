package com.example.travelapi.controllers;

import com.example.travelapi.dtos.CreateHolidayDTO;
import com.example.travelapi.dtos.ResponseHolidayDTO;
import com.example.travelapi.services.HolidayService;
import com.example.travelapi.services.HolidayServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/holidays")
@RequiredArgsConstructor
public class HolidayController {
//    POST /holidays
//    DELETE /holidays/{holidayId}
//    GET /holidays
//    GET /holidays/{holidayId}
//    PUT /holidays

    private final HolidayService holidayService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseHolidayDTO> createHoliday(@RequestBody CreateHolidayDTO createHolidayDTO) {
        ResponseHolidayDTO response = holidayService.createHoliday(createHolidayDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
