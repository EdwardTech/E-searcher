package com.edtech.wsearcherapi.service;


import com.edtech.wsearcherapi.model.dto.RequestProfile;
import com.edtech.wsearcherapi.model.dto.ResponseProfile;
import com.edtech.wsearcherapi.model.entity.CriminalsProfile;
import com.edtech.wsearcherapi.repository.ProfileRepository;
import com.edtech.wsearcherapi.utils.ProfileUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
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

    @Transactional
    public ResponseProfile updateProfile(UUID id, RequestProfile dto) throws Exception {
        CriminalsProfile criminalsProfile = profileRepository.findById(id)
                .orElseThrow(() -> new Exception("Профайл не найден"));
        BeanUtils.copyProperties(dto, criminalsProfile, ProfileUtils.getNullPropertyNames(dto));

        CriminalsProfile newProfile = profileRepository.save(criminalsProfile);
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
