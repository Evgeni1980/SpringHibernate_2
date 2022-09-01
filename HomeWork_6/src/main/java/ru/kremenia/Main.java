package ru.kremenia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.kremenia.model.Product;
import ru.kremenia.model.User;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Insert
        entityManager.getTransaction().begin();

        entityManager.persist(new Product("product_1","Telephone",1000));
        entityManager.persist(new Product("product_2","Tablet",1500));
        entityManager.persist(new Product("product_3","Headphones",150));

        entityManager.persist(new User("User_1"));
        entityManager.persist(new User("User_2"));
        entityManager.persist(new User("User_3"));

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}