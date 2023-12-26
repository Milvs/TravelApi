package com.example.travelapi.services;

import com.example.travelapi.dtos.CreateReservationDTO;
import com.example.travelapi.dtos.ResponseLocationDTO;
import com.example.travelapi.dtos.ResponseReservationDTO;
import com.example.travelapi.dtos.UpdateReservationDTO;
import com.example.travelapi.entities.Holiday;
import com.example.travelapi.entities.Location;
import com.example.travelapi.entities.Reservation;
import com.example.travelapi.repositories.HolidayRepository;
import com.example.travelapi.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final HolidayRepository holidayRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseReservationDTO createReservation(CreateReservationDTO createReservationDTO) {
        Holiday holiday = holidayRepository.findById(createReservationDTO.getHoliday()).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Holiday not found for id = %s", createReservationDTO.getHoliday());
            return new IllegalArgumentException(errorMessage);
        });
        Reservation reservation = Reservation.builder().contactName(createReservationDTO.getContactName())
                .phoneNumber(createReservationDTO.getPhoneNumber())
                .holiday(holiday)
                .build();

        reservationRepository.save(reservation);

        return modelMapper.map(reservation, ResponseReservationDTO.class);
    }

    @Override
    public void deleteReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Reservation not found for id = %s", id);
            return new IllegalArgumentException(errorMessage);
        });

        reservationRepository.delete(reservation);

    }

    @Override
    public List<ResponseReservationDTO> getAllReservation() {
        List<Reservation> reservations = reservationRepository.findAll();

        return reservations.stream().map(r->modelMapper.map(r,ResponseReservationDTO.class)).toList();
    }

    @Override
    public ResponseReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Reservation not found for id = %s", id);
            return new IllegalArgumentException(errorMessage);
        });

        return modelMapper.map(reservation, ResponseReservationDTO.class);
    }

    @Override
    public ResponseReservationDTO updateReservation(UpdateReservationDTO updateReservation) {
        Reservation reservation = reservationRepository.findById(updateReservation.getId()).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Reservation not found for id = %s", updateReservation.getId());
            return new IllegalArgumentException(errorMessage);
        });

        Holiday holiday = holidayRepository.findById(updateReservation.getHoliday()).orElseThrow(() -> {
            final String errorMessage =
                    String.format("Reservation not found for id = %s", updateReservation.getId());
            return new IllegalArgumentException(errorMessage);
        });

        reservation.setContactName(updateReservation.getContactName());
        reservation.setPhoneNumber(updateReservation.getPhoneNumber());
        reservation.setHoliday(holiday);
        reservationRepository.save(reservation);

        return modelMapper.map(reservation, ResponseReservationDTO.class);
    }

}


