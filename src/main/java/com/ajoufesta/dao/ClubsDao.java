package com.ajoufesta.dao;

import com.ajoufesta.domain.Clubs;
import com.mongodb.lang.NonNull;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClubsDao extends MongoRepository<Clubs, String> {
    @Cacheable(value = "clubs", key = "#day")
    Optional<Clubs> findByDay(Integer day);

    // @CacheEvict(value = "clubs", allEntries = true, beforeInvocation = true)
    @CachePut(value = "clubs", key = "#result.day")
    @Override
    <S extends Clubs> S save(@NonNull S entity);
}
