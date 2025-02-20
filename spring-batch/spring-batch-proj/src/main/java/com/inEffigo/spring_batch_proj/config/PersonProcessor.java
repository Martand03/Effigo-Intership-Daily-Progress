package com.inEffigo.spring_batch_proj.config;

import com.inEffigo.spring_batch_proj.entity.Person;
import org.springframework.batch.item.ItemProcessor;

public class PersonProcessor implements ItemProcessor<Person, Person> {
    @Override
    public Person process(Person person) throws Exception{

        person.setFirstName(person.getFirstName().toUpperCase());
        person.setLastName(person.getLastName().toLowerCase());

        return person;
    }
}
