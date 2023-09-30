package INTERFACES;


import DTO.Client;
import DTO.Employe;
import DTO.Person;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Iemploye  extends Iperson {

    Optional<Employe> SearchByMatricule(String matricule);
    List<Map<String, Object>> Search(String attributeName, String value)

    List<Map<String,Object>> GetAll();

}
