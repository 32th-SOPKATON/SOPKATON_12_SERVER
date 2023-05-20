package com.sopkaton.SOPKATON12_SERVER.controller;

import com.sopkaton.SOPKATON12_SERVER.controller.MissionDto;
import com.sopkaton.SOPKATON12_SERVER.common.dto.ApiResponseDto;
import com.sopkaton.SOPKATON12_SERVER.common.exception.SuccessStatus;
import com.sopkaton.SOPKATON12_SERVER.service.MissionListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionListController {

    private final MissionListService missionListService;

    @GetMapping("")
    public ApiResponseDto<List<MissionDto>> getBeforeMissionsByUserId(@RequestHeader("userId") Long userId) {
        List<MissionDto> missionDto = missionListService.getBeforeMissionsByUserId(userId);
        return ApiResponseDto.success(SuccessStatus.GET_MissionList, missionDto);
    }
}
