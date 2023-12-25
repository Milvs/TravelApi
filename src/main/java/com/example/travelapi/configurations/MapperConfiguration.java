package com.example.travelapi.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper mapper = new ModelMapper();
        return mapper;
    }
}