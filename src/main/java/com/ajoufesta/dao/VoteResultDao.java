package com.ajoufesta.dao;

import com.ajoufesta.domain.VoteResult;
import com.ajoufesta.dto.VoteResultCount;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VoteResultDao extends MongoRepository<VoteResult, String> {
    @Aggregation(pipeline = {
            "{ '$group': { '_id': '$selectedId', 'count': { '$sum': 1 } } }",
            "{ '$project': { 'selectedId': '$_id', 'count': 1, '_id': 0 } }"
    })
    List<VoteResultCount> countAllSelectedIds();
}
