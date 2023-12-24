package com.example.travelapi.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHolidayDTO {
    private Long id;
    private ResponseLocationDTO location;
    private String title;
    private Date startDate;

    private int duration;
    private Double price;
    private int freeSlots;
}
