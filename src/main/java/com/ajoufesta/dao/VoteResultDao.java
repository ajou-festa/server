package com.ajoufesta.dao;

import com.ajoufesta.domain.VoteResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoteResultDao extends MongoRepository<VoteResult, String> {
}
