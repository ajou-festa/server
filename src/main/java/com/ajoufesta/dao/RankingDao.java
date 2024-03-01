package com.ajoufesta.dao;

import com.ajoufesta.domain.Ranking;
import com.mongodb.lang.NonNull;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RankingDao extends MongoRepository<Ranking, String> {
    @Cacheable(value = "rankings")
    @Override
    List<Ranking> findAll();

    default List<Ranking> findTop3ByOrderByLevelDesc() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("level").descending());
        Page<Ranking> page = findAll(pageable);
        return page.getContent();
    }

    @CacheEvict(value = "rankings", allEntries = true, beforeInvocation = true)
    @Override
    <S extends Ranking> S save(@NonNull S entity);
}
