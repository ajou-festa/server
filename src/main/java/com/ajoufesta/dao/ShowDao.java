package com.ajoufesta.dao;

import com.ajoufesta.domain.Show;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ShowDao {

    public List<Show> findShowsByDay(String day) {
        // Mock data for the sake of example
        return Stream.of(
                Show.builder().id(1L).showName("Show 1").teamName("Team A").participants(List.of("Participant 1", "Participant 2")).startTime("1900").isNow(false).build(),
                Show.builder().id(2L).showName("Show 2").teamName("Team B").participants(List.of("Participant 3", "Participant 4")).startTime("1930").isNow(true).build()
        ).collect(Collectors.toList());
    }
}
