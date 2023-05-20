package com.sopkaton.SOPKATON12_SERVER.controller;

import com.sopkaton.SOPKATON12_SERVER.common.dto.ApiResponseDto;
import com.sopkaton.SOPKATON12_SERVER.controller.dto.request.MissionCompleteDto;
import com.sopkaton.SOPKATON12_SERVER.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.sopkaton.SOPKATON12_SERVER.common.exception.SuccessStatus.MISSION_CHECK_SUCCESS;
import static com.sopkaton.SOPKATON12_SERVER.common.exception.SuccessStatus.MISSION_COMPLETE_SUCCESS;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/mission/check/{missionId}")
    public ApiResponseDto checkMission(@RequestHeader(value = "Authorization") Long userId, @PathVariable Long missionId) {
        missionService.check(userId, missionId);
        return ApiResponseDto.success(MISSION_CHECK_SUCCESS);
    }

    @PostMapping("/mission/complete/{missionId}")
    public ApiResponseDto completeMission(@RequestHeader(value = "Authorization") Long userId,
                                          @PathVariable Long missionId,
                                          @RequestBody final MissionCompleteDto missionCompleteDto) {
        missionService.complete(userId, missionId, missionCompleteDto.getAnswer());
        return ApiResponseDto.success(MISSION_COMPLETE_SUCCESS);
    }
}
