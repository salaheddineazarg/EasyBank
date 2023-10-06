package interfaces;

import dto.Mission;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface iMission {

    Optional<Mission> AddMission(Mission mission);
    int DeleteMission(String code);

    Map<String,Object> GetAll();
    Optional<Mission> FindOne(String code);
}
