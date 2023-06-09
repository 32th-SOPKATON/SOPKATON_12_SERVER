package com.sopkaton.SOPKATON12_SERVER.controller;

import com.sopkaton.SOPKATON12_SERVER.common.dto.ApiResponseDto;
import com.sopkaton.SOPKATON12_SERVER.controller.dto.request.MissionCompleteDto;
import com.sopkaton.SOPKATON12_SERVER.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.sopkaton.SOPKATON12_SERVER.common.exception.SuccessStatus.*;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("/mission/check/{missionId}")
    public ApiResponseDto checkMission(@RequestHeader(value = "Authorization") String userId, @PathVariable Long missionId) {
        missionService.check(Long.valueOf(userId), missionId);
        return ApiResponseDto.success(MISSION_CHECK_SUCCESS);
    }

    @PostMapping("/mission/complete/{missionId}")
    public ApiResponseDto completeMission(@RequestHeader(value = "Authorization") String userId,
                                          @PathVariable Long missionId,
                                          @RequestBody final MissionCompleteDto missionCompleteDto) {
        missionService.complete(Long.valueOf(userId), missionId, missionCompleteDto.getAnswer());
        return ApiResponseDto.success(MISSION_COMPLETE_SUCCESS);
    }

    @GetMapping("/mission/ing")
    public ApiResponseDto getIngMission(@RequestHeader(value = "Authorization") String userId) {
        return ApiResponseDto.success(ING_MISSION_INQUIRY_SUCCESS, missionService.getIngMission(Long.valueOf(userId)));
    }

    @GetMapping("/mission/done")
    public ApiResponseDto getDoneMission(@RequestHeader(value = "Authorization") String userId) {
        return ApiResponseDto.success(DONE_MISSION_INQUIRY_SUCCESS, missionService.getDoneMission(Long.valueOf(userId)));
    }
}
