package com.example.travelapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Table(name = "locations")
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location { //Parent

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private int number;

    private String country;

    private String city;

    private String street;

    private String imageUrl;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL,mappedBy = "location")
    private Set<Holiday> holidays;
}
