package com.example.travelapi.configurations.converters;

import com.example.travelapi.dtos.ResponseLocationDTO;
import com.example.travelapi.entities.Location;
import org.modelmapper.AbstractConverter;

public class LocationToResponseLocationDTOConverter extends AbstractConverter<Location, ResponseLocationDTO> {
    @Override
    protected ResponseLocationDTO convert(final Location location) {
        return ResponseLocationDTO.builder().city(location.getCity())
                .country(location.getCountry())
                .street(location.getStreet())
                .imageUrl(location.getImageUrl())
                .number(String.valueOf(location.getNumber()))
                .build();
    }
}