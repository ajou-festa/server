package com.ajoufesta.dao;

import com.ajoufesta.domain.Clubs;
import com.ajoufesta.domain.DayBoothes;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClubDao extends MongoRepository<Clubs, String> {
    Optional<Clubs> findByDay(Integer day);
}
