package com.example.travelapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name = "reservations")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String contactName;

    @NotNull
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Holiday holiday;



}
