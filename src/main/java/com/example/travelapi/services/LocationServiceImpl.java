package com.example.travelapi.services;


import com.example.travelapi.dtos.CreateLocationDTO;
import com.example.travelapi.dtos.ResponseLocationDTO;
import com.example.travelapi.dtos.UpdateLocationDTO;
import com.example.travelapi.entities.Location;
import com.example.travelapi.exceptions.LocationNotFoundException;
import com.example.travelapi.repositories.LocationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService{

    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;

    @Transactional
    @Override
    public ResponseLocationDTO createLocation(CreateLocationDTO createLocationDTO) {
        Location location = Location.builder().city(createLocationDTO.getCity())
                .country(createLocationDTO.getCountry())
                .street(createLocationDTO.getStreet())
                .imageUrl(createLocationDTO.getImageUrl())
                .number(Integer.parseInt(createLocationDTO.getNumber())).build();

        locationRepository.save(location);

        return modelMapper.map(location,ResponseLocationDTO.class);
    }

    @Transactional
    @Override
    public void deleteLocationById(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Location not found for id = %s", id);
            return new LocationNotFoundException(errorMessage);
        });

        locationRepository.delete(location);
    }

    @Override
    public List<ResponseLocationDTO> getAllLocations() {
        List<Location> locations = locationRepository.findAll();

        return locations.stream().map(l->modelMapper.map(l,ResponseLocationDTO.class)).toList();
    }

    @Override
    public ResponseLocationDTO getLocationById(Long id) {
        Location location = locationRepository.findById(id).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Location not found for id = %s", id);
            return new LocationNotFoundException(errorMessage);
        });

        return modelMapper.map(location, ResponseLocationDTO.class);
    }

    @Transactional
    @Override
    public ResponseLocationDTO updateLocation(UpdateLocationDTO updateLocation) {
       Location location = locationRepository.findById(updateLocation.getId()).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Location not found for id = %s", updateLocation.getId());
            return new LocationNotFoundException(errorMessage);
        });

        location.setCity(updateLocation.getCity());
        location.setCountry(updateLocation.getCountry());
        location.setStreet(updateLocation.getStreet());
        location.setImageUrl(updateLocation.getImageUrl());
        location.setNumber(Integer.parseInt(updateLocation.getNumber()));
        locationRepository.save(location);

        return modelMapper.map(location, ResponseLocationDTO.class);
    }
}
