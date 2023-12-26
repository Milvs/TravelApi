package com.example.travelapi.services;

import com.example.travelapi.dtos.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface LocationService {
    ResponseLocationDTO createLocation(CreateLocationDTO createLocationDTO);

    void deleteLocationById(Long id);

    List<ResponseLocationDTO> getAllLocations();

    ResponseLocationDTO getLocationById(Long id);

    ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationDTO);
}
