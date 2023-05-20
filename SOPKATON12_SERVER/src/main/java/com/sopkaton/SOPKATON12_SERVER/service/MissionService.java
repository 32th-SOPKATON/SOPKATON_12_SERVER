package com.sopkaton.SOPKATON12_SERVER.service;

import com.sopkaton.SOPKATON12_SERVER.controller.dto.response.IngMissionDto;
import com.sopkaton.SOPKATON12_SERVER.domain.Mission;
import com.sopkaton.SOPKATON12_SERVER.domain.MissionState;
import com.sopkaton.SOPKATON12_SERVER.domain.State;
import com.sopkaton.SOPKATON12_SERVER.repository.MissionRepository;
import com.sopkaton.SOPKATON12_SERVER.repository.MissionStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


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

    public List<IngMissionDto> getIngMission(Long userId) {
        List<MissionState> missionStates = missionStateRepository.findByUserIdAndState(userId, State.DOING);
        return missionStates.stream()
                .map(missionState -> IngMissionDto.of(missionState.getMission())).collect(Collectors.toList());
    }

    public List<IngMissionDto> getDoneMission(Long userId) {
        List<MissionState> missionStates = missionStateRepository.findByUserIdAndState(userId, State.DONE);
        return missionStates.stream()
                .map(missionState -> IngMissionDto.of(missionState.getMission())).collect(Collectors.toList());
    }
}
