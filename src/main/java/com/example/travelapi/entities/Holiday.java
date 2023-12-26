package com.example.travelapi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Table(name = "holidays")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @NotNull
    private int freeSlots;

    @NotNull
    private int duration;

    @NotNull
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Location location;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "holiday")
    private Set<Reservation> reservations;

}
