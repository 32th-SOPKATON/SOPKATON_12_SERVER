package com.sopkaton.SOPKATON12_SERVER.repository;

import com.sopkaton.SOPKATON12_SERVER.domain.MissionState;
import com.sopkaton.SOPKATON12_SERVER.domain.State;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface MissionStateRepository extends Repository<MissionState, Long> {
     void save(MissionStateRepository missionState);

     int countByUser_IdAndState(Long userId, State state);

     List<MissionState> findByUser_IdAndState(Long userId, State state);

}
