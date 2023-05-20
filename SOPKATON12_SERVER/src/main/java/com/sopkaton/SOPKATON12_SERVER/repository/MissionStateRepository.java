package com.sopkaton.SOPKATON12_SERVER.repository;

import com.sopkaton.SOPKATON12_SERVER.domain.MissionState;
import com.sopkaton.SOPKATON12_SERVER.domain.State;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface MissionStateRepository extends Repository<MissionState, Long> {
     int countByUser_IdAndState(Long userId, State state);

     List<MissionState> findByUser_IdAndState(Long userId, State state);

     void save(MissionStateRepository missionState);
     Optional<MissionState> findByMissionIdAndUserId(Long missionId, Long userId);
     List<MissionState> findByUserIdAndState(Long userId, State state);
}
