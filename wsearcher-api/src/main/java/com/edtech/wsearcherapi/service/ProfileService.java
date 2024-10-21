package com.edtech.wsearcherapi.service;


import com.edtech.wsearcherapi.model.dto.RequestProfile;
import com.edtech.wsearcherapi.model.dto.ResponseProfile;
import com.edtech.wsearcherapi.model.entity.CriminalsProfile;
import com.edtech.wsearcherapi.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileService {

    private final KafkaSender kafkaSender;
    private final ProfileRepository profileRepository;

    public ProfileService(KafkaSender kafkaSender, ProfileRepository profileRepository) {
        this.kafkaSender = kafkaSender;
        this.profileRepository = profileRepository;
    }

    public void deleteProfile(UUID id) {
        profileRepository.deleteById(id);
        kafkaSender.sendMessage("Реализация отправки на уведомление о удалении профайла");
    }

    @Transactional
    public ResponseProfile createProfile(RequestProfile dto) {
        CriminalsProfile profile = this.buildProfile(dto);
        CriminalsProfile newProfile = profileRepository.save(profile);
        kafkaSender.sendMessage(newProfile.toString());

        return this.buildResponseProfile(newProfile);
    }

    private ResponseProfile buildResponseProfile(CriminalsProfile newProfile) {
        return new ResponseProfile()
                .setFirstName(newProfile.getFirstName())
                .setLastName(newProfile.getLastName())
                .setGender(newProfile.getGender())
                .setBirthDate(newProfile.getBirthDate());
    }

    private CriminalsProfile buildProfile(RequestProfile dto) {
        return new CriminalsProfile()
                .setFirstName(dto.getFirstName())
                .setLastName(dto.getLastName())
                .setCrimeType(dto.getCrimeType())
                .setBio(dto.getBio())
                .setGender(dto.getGender())
                .setBirthDate(dto.getBirthDate());
    }


}
