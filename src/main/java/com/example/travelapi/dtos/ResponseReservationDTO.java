package com.example.travelapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseReservationDTO {
    private Long id;
    private String contactName;
    private String phoneNumber;
    private ResponseHolidayDTO holiday;

}
