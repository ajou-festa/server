package com.ajoufesta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajoufesta.dao.BoothDao;
import com.ajoufesta.dao.BoothDao;
import com.ajoufesta.domain.Booth;
import com.ajoufesta.domain.DayBoothes;
import com.ajoufesta.domain.DayBoothes;
import com.ajoufesta.domain.Booth;
import com.ajoufesta.dto.BoothDto;
import com.ajoufesta.dto.BoothDto;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoothService {
    @Autowired
    private BoothDao boothDao;

    public DayBoothes saveDayBoothes(DayBoothes dayBoothes) {
        return boothDao.save(dayBoothes);
    }

    public List<BoothDto> getDayBoothesByDayAndSection(Integer day, String section) {
        Optional<DayBoothes> optionalDayBoothes;
        if (day == null) {
            optionalDayBoothes =  boothDao.findByDay(1);
        } else {
            optionalDayBoothes =  boothDao.findByDay(day);
        }
        return getBoothesFromDayBoothesBySection(optionalDayBoothes, section);
    }

    private List<BoothDto> getBoothesFromDayBoothesBySection(Optional<DayBoothes> optionalDayBoothes, String section){
        List<Booth> boothes = optionalDayBoothes.map(DayBoothes::getBoothes).orElse(Collections.emptyList());
        if(section!=null){
            boothes = filterBySection(boothes,section);
        }
        
        return this.convertToBoothDtoList(boothes);
    }

    private List<Booth> filterBySection(List<Booth> boothes, String section) {
        return boothes.stream()
                .filter(booth -> booth.getBoothLocation().startsWith(section))
                .collect(Collectors.toList());
    }

    // Booth 객체를 BoothDto 객체로 변환하는 함수
    private BoothDto convertToBoothDto(Booth booth) {
        return BoothDto.builder()
                .boothId(booth.getBoothId())
                .boothName(booth.getBoothName())
                .teamName(booth.getTeamName())
                .openTime(booth.getOpenTime())
                .closeTime(booth.getCloseTime())
                .description(booth.getDescription())
                .link(booth.getLink())
                .linkIconId(booth.getLinkIconId())
                .boothLocation(booth.getBoothLocation())
                .build();
    }

    // List<Booth>를 List<BoothDto>로 변환하는 함수
    private List<BoothDto> convertToBoothDtoList(List<Booth> boothes) {
        return boothes.stream()
                .map(this::convertToBoothDto)
                .collect(Collectors.toList());
    }
}
