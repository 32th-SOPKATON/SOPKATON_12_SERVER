package com.sopkaton.SOPKATON12_SERVER.controller.dto.response;

import com.sopkaton.SOPKATON12_SERVER.domain.Mission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
public class IngMissionDto {
    private Long missionId;
    private String missionTitle;
    private String missionContent;

    public static IngMissionDto of(Mission mission) {
        return new IngMissionDto(mission.getId(), mission.getTitle(), mission.getContent());
    }
}
