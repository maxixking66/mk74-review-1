package com.maktabsharif74.review.util;

import com.maktabsharif74.review.repository.UserRepository;
import com.maktabsharif74.review.repository.impl.UserRepositoryImpl;

import java.sql.SQLException;

public class ApplicationContext {

    private static final DataSource datasource;

    private static DatabaseInitializer databaseInitializer;

    private static UserRepository userRepository;

    static {
        System.out.println("start app context static block");
        try {
            datasource = new DataSource();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("can't create connection");
        } finally {
            System.out.println("end app context static block");
        }
    }

    private ApplicationContext() {
    }

    public static DatabaseInitializer getDatabaseInitializer() {
        if (databaseInitializer == null) {
            databaseInitializer = new DatabaseInitializer(datasource.getConnection());
        }
        return databaseInitializer;
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(datasource.getConnection());
        }
        return userRepository;
    }
}
