package com.example.travelapi.configurations.converters;

import com.example.travelapi.dtos.ResponseLocationDTO;
import com.example.travelapi.entities.Location;
import org.modelmapper.AbstractConverter;

public class LongToLocationConverter extends AbstractConverter<Long, Location> {
    @Override
    protected Location convert(final Long location) {
        return Location.builder().id(location).build();
    }
}
