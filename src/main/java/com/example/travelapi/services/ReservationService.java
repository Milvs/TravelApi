package com.example.travelapi.services;

import com.example.travelapi.dtos.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface ReservationService {
    ResponseReservationDTO createReservation(CreateReservationDTO createReservationDTO);

    void deleteReservationById(Long id);

    List<ResponseReservationDTO> getAllReservation();

    ResponseReservationDTO getReservationById(Long id);

    ResponseReservationDTO updateReservation(UpdateReservationDTO updateReservationDTO);
}
