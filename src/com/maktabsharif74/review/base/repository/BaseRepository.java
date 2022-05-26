package com.maktabsharif74.review.base.repository;

import com.maktabsharif74.review.base.domain.BaseDomain;

import java.util.List;

public interface BaseRepository</*domain*/T extends BaseDomain<ID>,/*id domain*/ ID> {

    T save(T t);

    T update(T t);

    void deleteById(ID id);

    T getById(ID id);

    List<T> findAll();

    Long countAll();
}
