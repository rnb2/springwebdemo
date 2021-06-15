package com.rnb.springwebdemo.dao;

import com.rnb.springwebdemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonAccessService implements PersonDao{
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> getAllPeople() {
        return List.of(new Person(UUID.randomUUID(), "From Postgres DB"));
    }

    @Override
    public Optional<Person> selectPerson(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public int deletePerson(UUID uuid) {
        return 0;
    }

    @Override
    public int updatePerson(UUID uuid, Person person) {
        return 0;
    }
}
