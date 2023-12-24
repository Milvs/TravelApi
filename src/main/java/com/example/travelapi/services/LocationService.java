package com.example.travelapi.services;

import com.example.travelapi.dtos.CreateLocationDTO;
import com.example.travelapi.dtos.ResponseLocationDTO;

public interface LocationService {
    ResponseLocationDTO createLocation(CreateLocationDTO createLocationDTO);
}
