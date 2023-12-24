package com.example.travelapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLocationDTO {
    private Long id;
    private String street;
    private String number;
    private String city;
    private String country;
    private String imageUrl;

}
