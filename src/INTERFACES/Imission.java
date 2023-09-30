package INTERFACES;

import DTO.Mission;

import java.util.Optional;

public interface Imission {

    Optional<Mission> AddMission(Mission mission);
    int DeleteMission(String code);
}
