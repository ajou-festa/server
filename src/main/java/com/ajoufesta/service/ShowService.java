package com.ajoufesta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajoufesta.dao.ShowDao;
import com.ajoufesta.domain.DayShows;
import com.ajoufesta.domain.Show;
import com.ajoufesta.dto.ShowDto;
import com.ajoufesta.dto.UpdateShowTurnDto;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShowService {
    @Autowired
    private ShowDao showDao;

    public DayShows saveDayShows(DayShows dayShows) {
        return showDao.save(dayShows);
    }

    public Integer updateShowTurn(UpdateShowTurnDto nowShow){
        DayShows dayShows = showDao.findByDay(nowShow.getDay()).orElseThrow();

        dayShows.updateShowStatus(nowShow.getShowId());
        dayShows.setStartTime(nowShow.getStartTime());
      
        return showDao.save(dayShows).getDay();
    }

    public List<ShowDto> getDayShowsByDay(Integer day) {
        Optional<DayShows> optionalDayShows;
        if (day == null) {
            optionalDayShows =  showDao.findByDay(1);
        } else {
            optionalDayShows =  showDao.findByDay(day);
        }
        return getShowsFromDayShows(optionalDayShows);
    }

    private List<ShowDto> getShowsFromDayShows(Optional<DayShows> optionalDayShows){
        List<Show> shows = optionalDayShows.map(DayShows::getShows).orElse(Collections.emptyList());
        return this.convertToShowDtoList(shows);
    }

    // Show 객체를 ShowDto 객체로 변환하는 함수
    private ShowDto convertToShowDto(Show show) {
        return ShowDto.builder()
                .id(show.getId())
                .showName(show.getShowName())
                .teamName(show.getTeamName())
                .status(show.getStatus())
                .startTime(show.getStartTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();
    }

    // List<Show>를 List<ShowDto>로 변환하는 함수
    private List<ShowDto> convertToShowDtoList(List<Show> shows) {
        return shows.stream()
                .map(this::convertToShowDto)
                .collect(Collectors.toList());
    }
}
