package com.example.travelapi.services;

import com.example.travelapi.dtos.*;

import java.util.List;


public interface ReservationService {
    ResponseReservationDTO createReservation(CreateReservationDTO createReservationDTO);

    void deleteReservationById(Long id);

    List<ResponseReservationDTO> getAllReservation();

    ResponseReservationDTO getReservationById(Long id);

    ResponseReservationDTO updateReservation(UpdateReservationDTO updateReservationDTO);
}
