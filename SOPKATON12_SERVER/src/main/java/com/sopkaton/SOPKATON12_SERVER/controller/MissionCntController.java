package com.sopkaton.SOPKATON12_SERVER.controller;

import com.sopkaton.SOPKATON12_SERVER.common.dto.ApiResponseDto;
import com.sopkaton.SOPKATON12_SERVER.common.exception.SuccessStatus;
import com.sopkaton.SOPKATON12_SERVER.service.MissionCntService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionCntController {

    private final MissionCntService missionCntService;

    @GetMapping("/count")
    public ApiResponseDto<Integer> getCompletedMissionCountByUserId(@RequestHeader("userId") String userId) {
        int completedMissionCount = missionCntService.getCompletedMissionCountByUserId(Long.valueOf(userId));
        return ApiResponseDto.success(SuccessStatus.COMPLETE_COUNT_SUCCESS, completedMissionCount);
    }
}