package interfaces;

import dto.Affectation;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface iAffictation {

    Optional<Affectation> AddAffictation(Affectation affictation);
    int DeleteAffictation(int id);

    Map<String,Object> HistoricAffictation();
    Affectation StatisticAffictation();

    Optional<Affectation> FindOne(String code);
}
