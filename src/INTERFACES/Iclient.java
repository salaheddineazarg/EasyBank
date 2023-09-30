package INTERFACES;

import DTO.Client;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Iclient extends Iperson {

    Optional<Client> SearchByCode(String code);
    List<Map<String, Object>> GetAll();
}
