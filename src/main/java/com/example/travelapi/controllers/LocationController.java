package com.example.travelapi.controllers;

import com.example.travelapi.dtos.CreateHolidayDTO;
import com.example.travelapi.dtos.CreateLocationDTO;
import com.example.travelapi.dtos.ResponseHolidayDTO;
import com.example.travelapi.dtos.ResponseLocationDTO;
import com.example.travelapi.services.HolidayService;
import com.example.travelapi.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseLocationDTO> createHoliday(@RequestBody CreateLocationDTO createLocationDTO) {
        ResponseLocationDTO response =locationService.createLocation(createLocationDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
