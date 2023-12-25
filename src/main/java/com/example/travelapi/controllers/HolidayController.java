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

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        if (response==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById( @PathVariable Long id) {
        boolean response = holidayService.deleteHolidayById(id);
        if (!response) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    //TODO:
    @GetMapping
    public ResponseEntity<List<ResponseHolidayDTO>> getAllHolidays(
            @RequestParam(required = false) Long location,
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) Integer duration
    ){
        List<ResponseHolidayDTO> holidays = holidayService.getAllHolidays(location,startDate,duration);
        if(holidays.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(holidays,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseHolidayDTO> getHolidayById(@PathVariable Long id){
        ResponseHolidayDTO holiday = holidayService.getHolidayById(id);
        if(holiday==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(holiday,HttpStatus.OK);
    }

}
