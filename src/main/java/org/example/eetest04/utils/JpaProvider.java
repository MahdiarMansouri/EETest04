package org.example.eetest04.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class JpaProvider {
    @Getter
    private static JpaProvider jpa = new JpaProvider();
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

    private JpaProvider() {}

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
