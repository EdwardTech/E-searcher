package com.edtech.wsearcherapi.model.dto;

import com.edtech.wsearcherapi.model.enums.CrimeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RequestProfile {
    private String firstName;
    private String lastName;
    private CrimeType crimeType;
    private String bio;
    private String gender;
    private LocalDate birthDate;
}
