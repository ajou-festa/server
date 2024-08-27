package com.ajoufesta.service;

import com.ajoufesta.dao.VoteResultDao;
import com.ajoufesta.domain.VoteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VoteService {

    @Autowired
    private VoteResultDao voteResultDao;

    public VoteResult saveVoteResult(Map<String, Integer> selectedImages) {
        VoteResult voteResult = VoteResult.builder()
                .selectedImages(selectedImages)
                .build();
        return voteResultDao.save(voteResult);
    }

    public Map<String, Long> getVoteStatistics() {
        List<VoteResult> allResults = voteResultDao.findAll();

        return allResults.stream()
                .flatMap(result -> result.getSelectedImages().entrySet().stream())
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.flatMapping(
                                entry -> List.of(entry.getValue()).stream(),
                                Collectors.counting()
                        )
                ));
    }
}
