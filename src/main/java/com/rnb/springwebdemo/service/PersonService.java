package com.rnb.springwebdemo.service;

import com.rnb.springwebdemo.dao.PersonDao;
import com.rnb.springwebdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;


    /**
     *
     * for DAO      use "fakeDao"  from FakePersonDaoAccessService.java
     * for Postgres use "postgres" from PersonAccessService.java
      */
    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.getAllPeople();
    }

    public Optional<Person> getPerson(UUID uuid){
        return personDao.selectPerson(uuid);
    }

    public int delePerson(UUID uuid){
        return personDao.deletePerson(uuid);
    }

    public int updatePerson(UUID uuid, Person person){
        return personDao.updatePerson(uuid, person);
    }
}
