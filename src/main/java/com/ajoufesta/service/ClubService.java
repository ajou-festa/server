package com.ajoufesta.service;

import com.ajoufesta.dao.ClubDao;
import com.ajoufesta.domain.Club;
import com.ajoufesta.domain.Clubs;
import com.ajoufesta.dto.*;
import com.ajoufesta.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubService {
    @Autowired
    private ClubDao clubDao;

    public String addBoothes(AddClubsDto addClubsDto) {
        for(Clubs clubs : addClubsDto.getClubsByDay()){
            clubDao.save(clubs);
        }
        return "success";
    }
    @CachePut(value = "clubs", key = "#result.day")
    public Clubs saveClubs(Clubs clubs) {
        return clubDao.save(clubs);
    }

    public List<ClubDto> getClubsByDayAndSection(Integer day, String section) {
        Optional<Clubs> optionalClubs;
        if (day == null) {
            optionalClubs = clubDao.findByDay(1);
        } else {
            optionalClubs = clubDao.findByDay(day);
        }
        return getClubsFromDayClubsBySection(optionalClubs, section);
    }

    public ClubDto updateClubInfo(String id, ClubDto clubDto) {
        UserInfoDto userInfoDto = SecurityUtil.getCurrentMemberId();
        System.out.println("uid " + userInfoDto);

        Clubs clubs = clubDao.findById(userInfoDto.getCode())
                .orElseThrow(() -> new IllegalArgumentException("잘못된 ID: " + userInfoDto.getCode()));

        clubs.getClubs().stream()
                .filter(club -> club.getClubId().equals(clubDto.getClubId()))
                .findFirst()
                .ifPresent(club -> {
                    club.setClubName(clubDto.getClubName());
                    club.setClubDetail(clubDto.getClubDetail());
                    club.setClubActivities(clubDto.getClubActivities());
                    club.setLink(clubDto.getLink());
                    club.setLinkIconId(clubDto.getLinkIconId());
                    club.setSection(clubDto.getSection());
                });
        clubDao.save(clubs);

        return clubDto;
    }

    private List<ClubDto> getClubsFromDayClubsBySection(Optional<Clubs> optionalClubs, String section) {
        List<Club> clubs = optionalClubs.map(Clubs::getClubs).orElse(Collections.emptyList());
        if (section != null) {
            clubs = filterBySection(clubs, section);
        }

        return this.convertToBoothDtoList(clubs);
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
                .clubDetail(club.getClubDetail())
                .clubActivities(club.getClubActivities())
                .link(club.getLink())
                .linkIconId(club.getLinkIconId())
                .section(club.getSection())
                .build();
    }

    // List<Club>를 List<ClubDto>로 변환하는 함수
    private List<ClubDto> convertToBoothDtoList(List<Club> clubs) {
        return clubs.stream()
                .map(this::convertToClubDto)
                .collect(Collectors.toList());
    }
}
