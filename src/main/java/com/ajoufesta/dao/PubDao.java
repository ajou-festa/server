package com.ajoufesta.dao;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajoufesta.domain.DayPubs;

import java.util.Optional;

public interface PubDao extends MongoRepository<DayPubs, String> {
    Optional<DayPubs> findByDay(Integer day);
}