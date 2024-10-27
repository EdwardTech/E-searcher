package com.edtech.wsearcherapi.repository;

import com.edtech.wsearcherapi.model.entity.CriminalsProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<CriminalsProfile, UUID> {

}
