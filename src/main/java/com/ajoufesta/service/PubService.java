package com.ajoufesta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import com.ajoufesta.dao.PubDao;
import com.ajoufesta.domain.Pub;
import com.ajoufesta.domain.DayPubs;
import com.ajoufesta.dto.AddPubsDto;
import com.ajoufesta.dto.PubDto;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PubService {
    @Autowired
    private PubDao pubDao;

    public String addDaySchedule(AddPubsDto dayPubs) {
        for(DayPubs dayPub : dayPubs.getPubsByDay()){
        pubDao.save(dayPub);
        }
        return "success";
    }

    public List<PubDto> getDayPubsByDayAndSection(Integer day, String section) {
        Optional<DayPubs> optionalDayPubs;
        if (day == null) {
            optionalDayPubs = pubDao.findByDay(1);
        } else {
            optionalDayPubs = pubDao.findByDay(day);
        }
        return getPubsFromDayPubsBySection(optionalDayPubs, section);
    }

    public PubDto updatePubInfo(String pubId, PubDto pubDto) {
        DayPubs dayPubs = pubDao.findById(pubId)
                .orElseThrow(() -> new IllegalArgumentException("Pub with id " + pubId + " not found"));

        dayPubs.getPubs().stream()
                .filter(pub -> pub.getPubId().equals(Long.parseLong(pubId)))
                .findFirst()
                .ifPresent(pub -> {
                    pub.setPubName(pubDto.getPubName());
                    pub.setTeamName(pubDto.getTeamName());
                    pub.setPhoneNum(pubDto.getPhoneNum());
                    pub.setDescription(pubDto.getDescription());
                    pub.setMenuImageSrc(pubDto.getMenuImageSrc());
                    pub.setLink(pubDto.getLink());
                    pub.setLinkIconId(pubDto.getLinkIconId());
                    pub.setPubLocation(pubDto.getPubLocation());
                });

        pubDao.save(dayPubs);

        return pubDto;
    }

    private List<PubDto> getPubsFromDayPubsBySection(Optional<DayPubs> optionalDayPubs, String section) {
        List<Pub> pubs = optionalDayPubs.map(DayPubs::getPubs).orElse(Collections.emptyList());
        if (section != null) {
            pubs = filterBySection(pubs, section);
        }

        return this.convertToPubDtoList(pubs);
    }

    private List<Pub> filterBySection(List<Pub> pubs, String section) {
        return pubs.stream()
                .filter(pub -> pub.getPubLocation().startsWith(section))
                .collect(Collectors.toList());
    }

    // Pub 객체를 PubDto 객체로 변환하는 함수
    private PubDto convertToPubDto(Pub pub) {
        return PubDto.builder()
                .pubId(pub.getPubId())
                .pubName(pub.getPubName())
                .teamName(pub.getTeamName())
                .phoneNum(pub.getPhoneNum())
                .description(pub.getDescription())
                .menuImageSrc(pub.getMenuImageSrc())
                .link(pub.getLink())
                .linkIconId(pub.getLinkIconId())
                .pubLocation(pub.getPubLocation())
                .build();
    }

    // List<Pub>를 List<PubDto>로 변환하는 함수
    private List<PubDto> convertToPubDtoList(List<Pub> pubs) {
        return pubs.stream()
                .map(this::convertToPubDto)
                .collect(Collectors.toList());
    }
}
