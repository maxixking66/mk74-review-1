package com.maktabsharif74.review.repository.impl;

import com.maktabsharif74.review.base.repository.BaseRepositoryImpl;
import com.maktabsharif74.review.domain.User;
import com.maktabsharif74.review.repository.UserRepository;

import java.sql.*;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long>
        implements UserRepository {

    public UserRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public User save(User user) throws SQLException {
        String columns = "`first_name`, `last_name`, `username`, `password`, `age`";
        /*String values = "'" + user.getFirstName() + "', " +
                        "'" + user.getLastName() + "', " +
                        "'" + user.getUsername() + "', " +
                        "'" + user.getPassword() + "', " +
                        user.getAge();*/
        String values = "?, ?, ?, ?, ?";
        String insertQuery = getInsertQuery(columns, values);
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setInt(5, user.getAge());
        preparedStatement.executeUpdate();
        user.setId(getMaxId());
        return user;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public String getDomainTableName() {
        return User.TABLE_NAME;
    }

    @Override
    public User convertResultSetToDomain(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getLong(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getString(5),
                resultSet.getInt(6)
        );
    }

    @Override
    public Long getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from " + getDomainTableName());
        if (resultSet.next()) {
            return resultSet.getLong(1);
        }
        return null;
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) {
        return null;
    }

}
