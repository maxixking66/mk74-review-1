package com.maktabsharif74.review.util;

import com.maktabsharif74.review.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private final Connection connection;

    private final String schemaName = "mk74_review_1";

    public DatabaseInitializer(Connection connection) {
        this.connection = connection;
    }

    public void init() {
        try {
            initSchema();
            initTables();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("can't init database");
        }
    }

    private void initSchema() throws SQLException {
        String createSchemaQuery = "CREATE SCHEMA IF NOT EXISTS " + schemaName + " " +
                "DEFAULT CHARACTER SET utf8 COLLATE utf8_persian_ci";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createSchemaQuery);

        statement.executeUpdate("USE " + schemaName);
    }

    private void initTables() throws SQLException {
        initUserTable();
    }

    private void initUserTable() throws SQLException {
        String createUserTableQuery =
                "CREATE TABLE IF NOT EXISTS " + User.TABLE_NAME + "(" +
                        "id bigint not null auto_increment," +
                        "first_name varchar(255)," +
                        "last_name varchar(255)," +
                        "username varchar(255)," +
                        "password varchar(255)," +
                        "age int," +
                        "primary key(id)" +
                        ")";
        PreparedStatement preparedStatement = connection.prepareStatement(createUserTableQuery);
        preparedStatement.executeUpdate();
    }
}
