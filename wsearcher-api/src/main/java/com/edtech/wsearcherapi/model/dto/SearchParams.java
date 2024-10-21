package com.edtech.wsearcherapi.model.dto;


import com.edtech.wsearcherapi.model.enums.CrimeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchParams {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private CrimeType crimeType;
}
