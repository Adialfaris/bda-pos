package com.bdajaya.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class DatabaseConfig {
    private static SessionFactory sessionFactory;
    private static Properties connectionProperties;

    public static void initializeDatabase(String url, String username, String password) {
        try {
            connectionProperties = new Properties();
            connectionProperties.setProperty("hibernate.connection.url", url);
            connectionProperties.setProperty("hibernate.connection.username", username);
            connectionProperties.setProperty("hibernate.connection.password", password);
            connectionProperties.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
            connectionProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            connectionProperties.setProperty("hibernate.show_sql", "true");
            connectionProperties.setProperty("hibernate.hbm2ddl.auto", "update");

            Configuration configuration = new Configuration();
            configuration.setProperties(connectionProperties);
            configuration.addAnnotatedClass(com.bdajaya.model.User.class);
            
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database: " + e.getMessage(), e);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            throw new IllegalStateException("Database not initialized. Call initializeDatabase first.");
        }
        return sessionFactory;
    }

    public static void updateConnection(String url, String username, String password) {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
        initializeDatabase(url, username, password);
    }
}