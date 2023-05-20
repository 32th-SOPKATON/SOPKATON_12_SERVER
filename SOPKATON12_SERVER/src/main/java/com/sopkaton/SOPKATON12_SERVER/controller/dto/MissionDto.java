package com.sopkaton.SOPKATON12_SERVER.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MissionDto {
    private Long missionId;
    private String missionTitle;
    private String missionContent;
}
