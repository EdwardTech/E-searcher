package com.edtech.wsearcherapi.controller;


import com.edtech.wsearcherapi.model.dto.RequestProfile;
import com.edtech.wsearcherapi.model.dto.ResponseProfile;
import com.edtech.wsearcherapi.service.ProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/profile")
@RestController
public class CrimeProfileController {

    private final ProfileService profileService;

    public CrimeProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ResponseProfile> createProfile(@RequestBody RequestProfile dto) {
        ResponseProfile profile = profileService.createProfile(dto);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteProfile(@RequestParam UUID id) {
        profileService.deleteProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
