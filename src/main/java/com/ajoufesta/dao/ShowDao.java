package com.ajoufesta.dao;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajoufesta.domain.DayShows;
import java.util.Optional;

public interface ShowDao extends MongoRepository<DayShows, String> {
    Optional<DayShows> findByDay(Integer day);
}
