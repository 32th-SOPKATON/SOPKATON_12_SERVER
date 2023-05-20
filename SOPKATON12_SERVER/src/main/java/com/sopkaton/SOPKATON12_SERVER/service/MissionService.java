package com.sopkaton.SOPKATON12_SERVER.service;

import com.sopkaton.SOPKATON12_SERVER.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository missionRepository;
}
