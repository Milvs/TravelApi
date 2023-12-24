package com.example.travelapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateReservationDTO {
    private Long id;
    private String contactName;
    private String phoneNumber;
    private Long holiday;

}
