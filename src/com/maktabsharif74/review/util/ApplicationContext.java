package com.maktabsharif74.review.util;

import java.sql.SQLException;

public class ApplicationContext {

    private static final DataSource datasource;
    private static DatabaseInitializer databaseInitializer;

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
}
