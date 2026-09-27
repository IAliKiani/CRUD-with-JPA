package org.ali.model.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPA {
    private JPA (){}
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CRUD-JPA");
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
