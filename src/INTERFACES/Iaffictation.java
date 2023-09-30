package INTERFACES;

import DTO.Affectation;

import java.util.List;

public interface Iaffictation {

    Affectation AddAffictation(Affectation affictation);
    int DeleteAffictation(int id);

    List<Affectation> HistoricAffictation();
    Affectation StatisticAffictation();
}
