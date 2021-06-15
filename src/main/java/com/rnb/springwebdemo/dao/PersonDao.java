package com.rnb.springwebdemo.dao;

import com.rnb.springwebdemo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID uuid = UUID.randomUUID();
        return insertPerson(uuid, person);
    }

    List<Person> getAllPeople();

    Optional<Person> selectPerson(UUID uuid);

    int deletePerson(UUID uuid);

    int updatePerson(UUID uuid, Person person);
}
