package com.sopkaton.SOPKATON12_SERVER.service;

import com.sopkaton.SOPKATON12_SERVER.domain.MissionState;
import com.sopkaton.SOPKATON12_SERVER.repository.MissionRepository;
import com.sopkaton.SOPKATON12_SERVER.repository.MissionStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionStateRepository missionStateRepository;

    @Transactional
    public void check(Long userId, Long missionId) {
        MissionState missionState = missionStateRepository.findByMissionIdAndUserId(missionId, userId)
                .orElseThrow(() -> new RuntimeException());

        missionState.check();
    }

    @Transactional
    public void complete(Long userId, Long missionId, String answer) {
        MissionState missionState = missionStateRepository.findByMissionIdAndUserId(missionId, userId)
                .orElseThrow(() -> new RuntimeException());

        missionState.done();
        missionState.updateAnswer(answer);
    }
}
