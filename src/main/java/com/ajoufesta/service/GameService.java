package com.ajoufesta.service;

import com.ajoufesta.dao.RankingDao;
import com.ajoufesta.domain.Ranking;
import com.ajoufesta.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GameService {
    @Autowired
    private RankingDao rankingDao;

   public List<RankingDto> getRanking() {
        // List<Ranking> allRankings;
        // allRankings = rankingDao.findAll();

        // return getTop3Rankings(allRankings);
        return convertToDto(rankingDao.findTop3ByOrderByLevelDesc());
    }

    public List<Ranking> getAllRanking() {
        List<Ranking> allRankings;
        allRankings = rankingDao.findAll();

        return allRankings;
    }

    // private List<RankingDto> getTop3Rankings(List<Ranking> rankings) {
    //     List<Ranking> tempRankings =  rankings.stream()
    //             .sorted((r1, r2) -> {
    //                 try {
    //                     return Integer.compare(r2.getLevel(), r1.getLevel());
    //                 } catch (NumberFormatException e) {
    //                     throw new IllegalArgumentException("Level must be a valid integer string", e);
    //                 }
    //             })
    //             .limit(3)
    //             .collect(Collectors.toList());
    //     return convertToDto(tempRankings);
    // }

     private List<RankingDto> convertToDto(List<Ranking> rankings) {
        return rankings.stream()
                .map(ranking -> RankingDto.builder()
                        .studentId(ranking.getStudentId())
                        .level(ranking.getLevel())
                        .name(ranking.getName())
                        .build())
                .collect(Collectors.toList());
    }

    public String addRanking(AddRankingDto addRankingDto){
        if(!addRankingDto.getPassword().equals("donghwa0302!A") ){
            return "not authentication";
        }
        Ranking ranking = Ranking.builder().studentId(addRankingDto.getStudentId()).name(addRankingDto.getName()).level(addRankingDto.getLevel()).build();
        rankingDao.save(ranking);
        return "success";
    }
}
