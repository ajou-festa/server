package com.ajoufesta.dao;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajoufesta.domain.DayShows;
import com.mongodb.lang.NonNull;

import java.util.Optional;

public interface ShowDao extends MongoRepository<DayShows, String> {
    @Cacheable(value = "shows", key = "#day", unless = "#result == null")
    Optional<DayShows> findByDay(Integer day);

    @CachePut(value = "shows", key = "#result.day")
    @Override
    <S extends DayShows> S save(@NonNull S entity);
}
