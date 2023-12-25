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
public class CreateHolidayDTO {
    private Long location;
    private String title;
    private Date startDate;
    private int duration;
    private String price;
    private int freeSlots;


}
