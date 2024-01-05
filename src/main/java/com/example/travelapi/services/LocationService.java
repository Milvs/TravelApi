package com.example.travelapi.services;

import com.example.travelapi.dtos.*;

import java.util.List;


public interface LocationService {
    ResponseLocationDTO createLocation(CreateLocationDTO createLocationDTO);

    void deleteLocationById(Long id);

    List<ResponseLocationDTO> getAllLocations();

    ResponseLocationDTO getLocationById(Long id);

    ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocationDTO);
}
