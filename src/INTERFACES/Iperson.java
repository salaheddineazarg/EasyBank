package INTERFACES;

import DTO.Person;

import java.util.Optional;

public interface Iperson {

    Optional<Person> AddPerson(Person person);
    int DeletePerson(String keyword);
    Optional<Person> UpdatePerson(Person person);

}
