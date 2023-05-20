package com.sopkaton.SOPKATON12_SERVER.controller;

import com.sopkaton.SOPKATON12_SERVER.common.dto.ApiResponseDto;
import com.sopkaton.SOPKATON12_SERVER.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static com.sopkaton.SOPKATON12_SERVER.common.exception.SuccessStatus.MISSION_CHECK_SUCCESS;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/mission/check/{missionId}")
    public ApiResponseDto checkMission(@RequestHeader(value = "Authorization") Long userId, @PathVariable Long missionId) {
        missionService.check(userId, missionId);
        return ApiResponseDto.success(MISSION_CHECK_SUCCESS);
    }
}
