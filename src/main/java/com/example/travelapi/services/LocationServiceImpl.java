package com.example.travelapi.services;


import com.example.travelapi.dtos.CreateLocationDTO;
import com.example.travelapi.dtos.ResponseLocationDTO;
import com.example.travelapi.entities.Location;
import com.example.travelapi.repositories.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService{

    private final LocationRepository locationRepository;
    private final ModelMapper modelMapper;
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
}
