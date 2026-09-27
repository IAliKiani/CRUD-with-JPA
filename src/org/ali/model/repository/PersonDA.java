package org.ali.model.repository;


import org.ali.model.common.JPA;
import org.ali.model.common.exepts.ExistedPerson;
import org.ali.model.common.exepts.NoRecord;
import org.ali.model.common.exepts.NotExistRecord;
import org.ali.model.common.exepts.NotUpToDate;
import org.ali.model.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class PersonDA implements AutoCloseable{
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public PersonDA() throws Exception{
        entityManager = JPA.getEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void insert(Person person) throws Exception{
        String jpql = "select count(p) from person  p where p.nationalCode = :code";
        Long count = entityManager.createQuery(jpql, Long.class)
                .setParameter("code", person.getNationalCode())
                .getSingleResult();
        if(count > 0){
            throw new ExistedPerson("Person already exist");
        }
        transaction.begin();
        entityManager.persist(person);
    }

    public void update(Person aPerson) throws Exception{
        transaction.begin();
        Person person = entityManager.find(Person.class, aPerson.getId());
        if (person == null) {
            throw new NotExistRecord("This person has already been removed.");
        }
        if (aPerson.getVersion() != person.getVersion()) {
            throw new NotUpToDate("This record has changed; view the new status and then make changes.");
        }
            person.setName(aPerson.getName());
            person.setAge(aPerson.getAge());
            person.setFamily(aPerson.getFamily());
            entityManager.persist(person);


    }

    public void delete(Person aPerson) throws Exception{
        transaction.begin();
        Person person = entityManager.find(Person.class, aPerson.getId());
        if (person == null) {
            throw new NotExistRecord("This person has already been removed.");
        }
        if (aPerson.getVersion() != person.getVersion()) {
            throw new NotUpToDate("This record has changed; view the new status and then make changes.");
        }
        entityManager.remove(person);
    }

    public List<Person> findAll() throws Exception{
        Query query = entityManager.createQuery("select person from person person");
        if (query.getResultList().isEmpty()) {
            throw new NoRecord("Table is empty");
        }
        return query.getResultList();
    }

    public void commit()throws SQLException {
        transaction.commit();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
