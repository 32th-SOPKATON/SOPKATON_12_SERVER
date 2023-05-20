package com.sopkaton.SOPKATON12_SERVER.repository;

import com.sopkaton.SOPKATON12_SERVER.domain.MissionState;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface MissionStateRepository extends Repository<MissionState, Long> {

     void save(MissionStateRepository missionState);
     Optional<MissionState> findByMissionIdAndUserId(Long missionId, Long userId);
}
