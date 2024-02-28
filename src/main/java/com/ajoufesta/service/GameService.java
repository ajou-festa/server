package com.ajoufesta.service;

import com.ajoufesta.dao.ClubDao;
import com.ajoufesta.dao.RankingDao;
import com.ajoufesta.domain.Club;
import com.ajoufesta.domain.Clubs;
import com.ajoufesta.domain.Ranking;
import com.ajoufesta.dto.*;
import com.ajoufesta.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.management.Query;

@Service
public class GameService {
    @Autowired
    private RankingDao rankingDao;

   public List<Ranking> getRanking() {
        List<Ranking> allRankings;
        allRankings = rankingDao.findAll();

        return getTop3Rankings(allRankings);
    }

    private List<Ranking> getTop3Rankings(List<Ranking> rankings) {
        // level이 숫자를 나타내는 문자열이라고 가정하고 정렬
        return rankings.stream()
                .sorted((r1, r2) -> {
                    // level 값을 Integer로 변환하여 비교
                    // level이 실제로 숫자 형태의 문자열이 아니라면 예외 처리 필요
                    try {
                        return Integer.compare(r2.getLevel(), r1.getLevel());
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Level must be a valid integer string", e);
                    }
                })
                .limit(3) // 상위 3개만 추출
                .collect(Collectors.toList());
    }

    public String addRanking(AddRankingDto addRankingDto){
        Ranking ranking = Ranking.builder().studentId(addRankingDto.getStudentId()).name(addRankingDto.getName()).level(addRankingDto.getLevel()).build();
        rankingDao.save(ranking);
        return "success";
    }
}
