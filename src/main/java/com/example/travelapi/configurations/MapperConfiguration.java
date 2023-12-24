package com.example.travelapi.configurations;

import com.example.travelapi.configurations.converters.LocationToResponseLocationDTOConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper mapper = new ModelMapper();
        mapper.addConverter(new LocationToResponseLocationDTOConverter());
        return mapper;
    }
}