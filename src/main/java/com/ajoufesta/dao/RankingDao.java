package com.ajoufesta.dao;

import com.ajoufesta.domain.Ranking;
import com.mongodb.lang.NonNull;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RankingDao extends MongoRepository<Ranking, String> {
    @Cacheable(value = "rankings")
    @Override
    List<Ranking> findAll();

    @CacheEvict(value = "rankings", allEntries = true, beforeInvocation = true)
    @Override
    <S extends Ranking> S save(@NonNull S entity);
}
