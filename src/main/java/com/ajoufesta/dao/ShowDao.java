package com.ajoufesta.dao;

// import com.ajoufesta.domain.Show;
// import org.springframework.stereotype.Repository;

// import java.util.List;
// import java.util.stream.Collectors;
// import java.util.stream.Stream;

// @Repository
// public class ShowDao extends MongoRepository<Chat, String>  {
//     List<Chat> findShowsByDay(String day);
//     // public List<Show> findShowsByDay(String day) {
//     //     // Mock data for the sake of example
//     //     return Stream.of(
//     //             Show.builder().id(1L).showName("Show 1").teamName("Team A").participants(List.of("Participant 1", "Participant 2")).startTime("1900").isNow(false).build(),
//     //             Show.builder().id(2L).showName("Show 2").teamName("Team B").participants(List.of("Participant 3", "Participant 4")).startTime("1930").isNow(true).build()
//     //     ).collect(Collectors.toList());
//     // }
// }

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.ajoufesta.domain.DaySchedule;

public interface ShowDao extends MongoRepository<DaySchedule, String> {
    // 필요한 경우 여기에 추가 쿼리 메서드를 정의할 수 있습니다.
}
