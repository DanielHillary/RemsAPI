package com.jovine.nafa.service;

import com.jovine.nafa.repository.GamesRepository;
import com.jovine.nafa.repository.TeamsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {
    @Autowired
    private GamesRepository gamesRepository;
    @Autowired
    private TeamsRepo teamsRepo;

}
