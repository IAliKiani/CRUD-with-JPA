package org.ali.model.service;

import org.ali.model.common.exepts.NotLegalAge;
import org.ali.model.common.exepts.NotLogicalAge;
import org.ali.model.entity.Person;
import org.ali.model.repository.PersonDA;

import java.util.List;

public class PersonService {
    private static final PersonService PERSON_SERVICE = new PersonService();
    private PersonService() {}
    public static PersonService getInstance() {
        return PERSON_SERVICE;
    }

    public void save(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()){
            if (person.getAge()<18) {
                throw new NotLegalAge("Age must be greater than 18");
            }
            if (person.getAge()>=100) {
                throw new NotLogicalAge("Age must be under 100");
            }

            personDA.insert(person);
            personDA.commit();
        }
    }

    public void update(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()){

            if (person.getAge()<18) {
                throw new NotLegalAge("Age must be greater than 18");
            }
            if (person.getAge()>=100) {
                throw new NotLogicalAge("Age must be under 100");
            }

            personDA.update(person);
            personDA.commit();
        }
    }

    public void remove(Person person) throws Exception {
        try (PersonDA personDA = new PersonDA()){
            personDA.delete(person);
            personDA.commit();
        }
    }

    public List<Person> selectAll() throws Exception {
        try (PersonDA personDA = new PersonDA()){
            return personDA.findAll();
        }
    }


}
