package com.ajoufesta.dao;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ajoufesta.domain.DayBoothes;
import java.util.Optional;

public interface BoothDao extends MongoRepository<DayBoothes, String> {
    Optional<DayBoothes> findByDay(Integer day);
}
