package com.jovine.nafa.repository;

import com.jovine.nafa.entity.Leagues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeagueRepository extends JpaRepository<Leagues, Long> {
    List<Leagues> findByLeagueTournament(String tournament);
}
