package com.example.travelapi.controllers;

import com.example.travelapi.dtos.CreateHolidayDTO;
import com.example.travelapi.dtos.ResponseHolidayDTO;
import com.example.travelapi.dtos.UpdateHolidayDTO;
import com.example.travelapi.services.HolidayService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/holidays")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HolidayController {

    private final HolidayService holidayService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseHolidayDTO> createHoliday(@RequestBody CreateHolidayDTO createHolidayDTO) {
        ResponseHolidayDTO response = holidayService.createHoliday(createHolidayDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        holidayService.deleteHolidayById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseHolidayDTO>> getAllHolidays(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(required = false) Integer duration) {
        List<ResponseHolidayDTO> holidays = holidayService.getAllHolidaysByFilters(location, startDate, duration);
        return new ResponseEntity<>(holidays, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseHolidayDTO> getHolidayById(@PathVariable Long id) {
        ResponseHolidayDTO holiday = holidayService.getHolidayById(id);
        return new ResponseEntity<>(holiday, HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseHolidayDTO> updateHoliday(@RequestBody UpdateHolidayDTO updateHolidayDTO) {
        ResponseHolidayDTO holiday = holidayService.updateHoliday(updateHolidayDTO);
        return new ResponseEntity<>(holiday, HttpStatus.OK);
    }

}
