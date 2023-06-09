package com.sopkaton.SOPKATON12_SERVER.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
public enum SuccessStatus {

    /*
    mission
     */
    MISSION_INQUIRY_SUCCESS(HttpStatus.OK, "미션 조회 성공"),
    MISSION_CHECK_SUCCESS(HttpStatus.OK, "해당 미션 선택 완료"),
    MISSION_COMPLETE_SUCCESS(HttpStatus.OK, "해당 미션 수행 완료"),
    ING_MISSION_INQUIRY_SUCCESS(HttpStatus.OK, "진행중인 미션 조회 성공"),
    DONE_MISSION_INQUIRY_SUCCESS(HttpStatus.OK, "이미 수행한 미션 조회 성공"),

    GET_MissionList(HttpStatus.OK, "미션 조회 성공"),
    COMPLETE_COUNT_SUCCESS(HttpStatus.OK, "완료한 미션 개수 조회 성공");

    private final HttpStatus httpStatus;
    private final String message;
}