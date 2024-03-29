package com.ajoufesta.service;

import com.ajoufesta.dao.ShowDao;
import com.ajoufesta.dto.ShowDto;
import com.ajoufesta.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowService {

    @Autowired
    private ShowDao showDao;

    public List<ShowDto> getShowsByDay(String day) {
       return showDao.findShowsByDay(day).stream()
            .map(show -> ShowDto.builder()
                         .id(show.getId())
                         .showName(show.getShowName())
                         .isNow(show.isNow())
                         .teamName(show.getTeamName())
                         .startTime(show.getStartTime())
                         .participants(show.getParticipants())
                         .build()).collect(Collectors.toList());
    }
}
