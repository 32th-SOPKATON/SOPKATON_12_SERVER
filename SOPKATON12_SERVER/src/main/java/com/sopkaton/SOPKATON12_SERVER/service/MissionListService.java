package com.sopkaton.SOPKATON12_SERVER.service;

import com.sopkaton.SOPKATON12_SERVER.controller.MissionDto;
import com.sopkaton.SOPKATON12_SERVER.domain.Mission;
import com.sopkaton.SOPKATON12_SERVER.domain.MissionState;
import com.sopkaton.SOPKATON12_SERVER.domain.State;
import com.sopkaton.SOPKATON12_SERVER.repository.MissionStateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionListService {

    private final MissionStateRepository missionStateRepository;

    public List<MissionDto> getBeforeMissionsByUserId(Long userId) {
        List<MissionDto> missionDtoList = new ArrayList<>();

        List<MissionState> missionStates = missionStateRepository.findByUser_IdAndState(userId, State.BEFORE);
        for (MissionState missionState : missionStates) {
            Mission mission = missionState.getMission();
            MissionDto missionDto = new MissionDto(
                    mission.getId(),
                    mission.getTitle(),
                    mission.getContent()
            );
            missionDtoList.add(missionDto);
        }

        return missionDtoList;
    }
}
