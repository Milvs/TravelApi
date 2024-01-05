package com.example.travelapi.controllers;

import com.example.travelapi.dtos.*;
import com.example.travelapi.services.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class LocationController {

    private final LocationService locationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseLocationDTO> createHoliday(@RequestBody CreateLocationDTO createLocationDTO) {
        ResponseLocationDTO response = locationService.createLocation(createLocationDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id) {
        locationService.deleteLocationById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseLocationDTO>> getAllLocations() {
        List<ResponseLocationDTO> locations = locationService.getAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseLocationDTO> getLocationById(@PathVariable Long id) {
        ResponseLocationDTO location = locationService.getLocationById(id);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseLocationDTO> updateLocation(@RequestBody UpdateLocationDTO updateLocationDTO) {
        ResponseLocationDTO location = locationService.updateLocation(updateLocationDTO);
        return new ResponseEntity<>(location, HttpStatus.OK);
    }

}
