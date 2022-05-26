package com.maktabsharif74.review.repository;

import com.maktabsharif74.review.base.repository.BaseRepository;
import com.maktabsharif74.review.domain.User;

import java.sql.SQLException;

public interface UserRepository extends BaseRepository<User, Long> {

    Long getMaxId() throws SQLException;

    User getByUsernameAndPassword(String username, String password);

}
