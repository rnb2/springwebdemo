package com.rnb.springwebdemo.api;

import com.rnb.springwebdemo.model.Person;
import com.rnb.springwebdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @NotBlank @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPerson(@PathVariable("id") UUID uuid) {
        return personService.getPerson(uuid).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID uuid) {
        personService.delePerson(uuid);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID uuid, @Valid @NonNull  @RequestBody Person person){
     personService.updatePerson(uuid, person);
    }

}
