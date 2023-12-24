package com.example.travelapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHolidayDTO {
    private Long id;
    private Long location;
    private String title;
    private Date startDate;
    private int duration;
    private String price;
    private int freeSlots;
}
