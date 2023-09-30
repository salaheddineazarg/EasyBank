package DAO;

import DTO.Affectation;
import INTERFACES.Iaffictation;

import java.util.List;

public class AffictationD implements Iaffictation {
    @Override
    public Affectation AddAffictation(Affectation affictation) {
        return null;
    }

    @Override
    public int DeleteAffictation(int id) {
        return 0;
    }

    @Override
    public List<Affectation> HistoricAffictation() {
        return null;
    }

    @Override
    public Affectation StatisticAffictation() {
        return null;
    }
}
