package com.ajoufesta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajoufesta.dao.ShowDao;
import com.ajoufesta.domain.DaySchedule;

import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowDao repository;

    public DaySchedule saveDaySchedule(DaySchedule daySchedule) {
        return repository.save(daySchedule);
    }

    public List<DaySchedule> getAllDaySchedules() {
        return repository.findAll();
    }

    public Optional<DaySchedule> getDayScheduleById(String id) {
        return repository.findById(id);
    }

    // 여기에 필요한 경우 추가 로직을 구현합니다.
}
