package com.sopkaton.SOPKATON12_SERVER.repository;

import com.sopkaton.SOPKATON12_SERVER.domain.Mission;
import org.springframework.data.repository.Repository;

public interface MissionRepository extends Repository<Mission, Long> {

    void save(Mission mission);
}
