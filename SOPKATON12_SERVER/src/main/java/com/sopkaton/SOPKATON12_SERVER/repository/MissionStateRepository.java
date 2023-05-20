package com.sopkaton.SOPKATON12_SERVER.repository;

import com.sopkaton.SOPKATON12_SERVER.domain.MissionState;
import com.sopkaton.SOPKATON12_SERVER.domain.State;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface MissionStateRepository extends Repository<MissionState, Long> {

     void save(MissionStateRepository missionState);
     Optional<MissionState> findByMissionIdAndUserId(Long missionId, Long userId);
     Optional<MissionState> findByUserIdAndState(Long userId, State state);
}
