package com.ajoufesta.service;

import com.ajoufesta.dao.VoteResultDao;
import com.ajoufesta.domain.VoteResult;
import com.ajoufesta.dto.VoteResultCount;
import com.ajoufesta.dto.VoteResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteResultDao voteResultDao;

    public VoteResult saveVoteResult(VoteResultDto voteResultDto) {
        VoteResult voteResult = VoteResult.builder()
                .selectedId(voteResultDto.getSelectedId())
                .build();
        return voteResultDao.save(voteResult);
    }

    public List<VoteResultCount> getVoteStatistics() {
        return voteResultDao.countAllSelectedIds();
    }
}
