package com.maktabsharif74.review.base.repository;

import com.maktabsharif74.review.base.domain.BaseDomain;

import java.sql.SQLException;
import java.util.List;

public interface BaseRepository</*domain*/T extends BaseDomain<ID>,/*id domain*/ ID> {

    T save(T t) throws SQLException;

    T update(T t);

    void deleteById(ID id) throws SQLException;

    T getById(ID id) throws SQLException;

    List<T> findAll() throws SQLException;

    Long countAll() throws SQLException;
}
