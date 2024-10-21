package com.edtech.wsearcherapi.model.entity;

import com.edtech.wsearcherapi.model.enums.CrimeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.UUID;


@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "criminals_profile")
@Entity
public class CriminalsProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(name = "crime_type", nullable = false)
    private CrimeType crimeType;
    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "birth_date")
    private LocalDate birthDate;


}
