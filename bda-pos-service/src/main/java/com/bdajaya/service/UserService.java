package com.bdajaya.service;

import com.bdajaya.database.DatabaseConfig;
import com.bdajaya.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserService {
    public User authenticate(String username, String password) {
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<User> query = cb.createQuery(User.class);
            Root<User> root = query.from(User.class);
            
            query.select(root)
                 .where(cb.and(
                     cb.equal(root.get("username"), username),
                     cb.equal(root.get("password"), password)
                 ));
            
            return session.createQuery(query)
                         .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = DatabaseConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }
}