package interfaces;


import dto.Employe;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface iEmploye extends iPerson<Employe> {

    Optional<Employe> SearchByMatricule(String matricule);
    Map<String, Object> Search(String attributeName, String value);

    Map<String,Object> GetAll();

}
