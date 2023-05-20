package com.sopkaton.SOPKATON12_SERVER.service;

import com.sopkaton.SOPKATON12_SERVER.domain.State;
import com.sopkaton.SOPKATON12_SERVER.repository.MissionStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MissionCntService {

    private final MissionStateRepository missionStateRepository;

    @Autowired
    public MissionCntService(MissionStateRepository missionStateRepository) {
        this.missionStateRepository = missionStateRepository;
    }

    public int getCompletedMissionCountByUserId(Long userId) {
        return missionStateRepository.countByUser_IdAndState(userId, State.DONE);
    }
}
