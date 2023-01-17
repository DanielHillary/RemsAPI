package com.jovine.nafa.repository;

import com.jovine.nafa.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamsRepo extends JpaRepository<Teams, Long> {
    List<Teams> findByLeagueId(Long leagueId);

    Optional<Teams> findByTeamName(String name);

    List<Teams> findByTeamState(String state);
}
