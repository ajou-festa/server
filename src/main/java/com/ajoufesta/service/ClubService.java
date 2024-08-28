package com.ajoufesta.service;

import com.ajoufesta.dao.ClubsDao;
import com.ajoufesta.domain.Club;
import com.ajoufesta.domain.Clubs;
import com.ajoufesta.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubService {
    @Autowired
    private ClubsDao clubsDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    public String addClubs(AddClubsDto addClubsDto) {
        for(Clubs clubs : addClubsDto.getClubsByDay()){
            saveClubs(clubs);
        }
        return "success";
    }

    private Clubs saveClubs(Clubs clubs) {
        return clubsDao.save(clubs);
    }
    
    public List<ClubDto> getClubsByDayAndSection(Integer day, String section) {
        Optional<Clubs> optionalClubs;
        if (day == null) {
            optionalClubs = clubsDao.findByDay(1);
        } else {
            optionalClubs = clubsDao.findByDay(day);
        }
        return getClubsFromDayClubsBySection(optionalClubs, section);
    }

    private List<ClubDto> getClubsFromDayClubsBySection(Optional<Clubs> optionalClubs, String section) {
        List<Club> clubs = optionalClubs.map(Clubs::getClubs).orElse(Collections.emptyList());
        if (section != null) {
            clubs = filterBySection(clubs, section);
        }

        return this.convertToBoothDtoList(clubs);
    }

    public List<ClubDto> getAllClubs() {
        return getAllClubsForDay(1);
    }

    public List<ClubDto> getAllClubsForDay(int day) {
        Optional<Clubs> optionalClubs = clubsDao.findByDay(day);
        return optionalClubs
                .map(Clubs::getClubs)
                .map(this::convertToBoothDtoList)
                .orElse(Collections.emptyList());
    }

    public Optional<ClubDto> findClubById(Long clubId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("clubs._id").is(clubId));

        Clubs result = mongoTemplate.findOne(query, Clubs.class);

        if (result != null) {
            return result.getClubs().stream()
                    .filter(club -> club.getClubId().equals(clubId))
                    .map(this::convertToClubDto)
                    .findFirst();
        }

        return Optional.empty();
    }

    private List<Club> filterBySection(List<Club> clubs, String section) {
        return clubs.stream()
                .filter(club -> club.getSection().equals(section))
                .collect(Collectors.toList());
    }

    // Club 객체를 ClubDto 객체로 변환하는 함수
    private ClubDto convertToClubDto(Club club) {
        return ClubDto.builder()
                .clubId(club.getClubId())
                .clubName(club.getClubName())
                .clubRepresentative(club.getClubRepresentative())
                .clubDetail(club.getClubDetail())
                .clubActivities(club.getClubActivities())
                .link(club.getLink())
                .linkIconId(club.getLinkIconId())
                .section(club.getSection())
                .phoneNumber(club.getPhoneNumber())
                .build();
    }

    // List<Club>를 List<ClubDto>로 변환하는 함수
    private List<ClubDto> convertToBoothDtoList(List<Club> clubs) {
        return clubs.stream()
                .map(this::convertToClubDto)
                .collect(Collectors.toList());
    }
}
