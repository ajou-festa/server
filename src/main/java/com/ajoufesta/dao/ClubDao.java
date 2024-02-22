package com.ajoufesta.dao;

import com.ajoufesta.domain.Clubs;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClubDao extends MongoRepository<Clubs, String> {
    @Cacheable(value = "clubs", key = "#day", unless = "#result == null")
    Optional<Clubs> findByDay(Integer day);
}
