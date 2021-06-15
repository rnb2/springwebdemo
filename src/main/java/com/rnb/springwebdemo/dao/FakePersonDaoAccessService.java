package com.rnb.springwebdemo.dao;

import com.rnb.springwebdemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//@Component – Indicates a auto scan component.
//@Repository – Indicates DAO component in the persistence layer.
//@Service – Indicates a Service component in the business layer.
//@Controller – Indicates a controller component in the presentation layer.

@Repository("fakeDao")
public class FakePersonDaoAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
         DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPerson(UUID uuid) {
        return DB.stream()
                .filter(person -> person.getId().equals(uuid))
                .findFirst();
    }

    @Override
    public int deletePerson(UUID uuid) {
        final Optional<Person> personOptional = selectPerson(uuid);
        if (personOptional.isEmpty()) {
            return 0;
        }
        DB.remove(personOptional.get());
        return 1;
    }

    @Override
    public int updatePerson(UUID uuid, Person person) {
        return selectPerson(uuid)
                .map(person1 -> {
                    int indexToUpdate = DB.indexOf(person1);
                    System.out.println("indexToUpdate " + indexToUpdate);
                    if (indexToUpdate >= 0) {
                        DB.set(indexToUpdate, new Person(uuid, person.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
