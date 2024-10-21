package com.edtech.wsearcherapi.model.dto;

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
public class ResponseProfile {
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthDate;
}
