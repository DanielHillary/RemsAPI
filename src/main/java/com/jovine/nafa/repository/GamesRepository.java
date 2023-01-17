package com.jovine.nafa.repository;

import com.jovine.nafa.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GamesRepository extends JpaRepository<Games, Long> {
    List<Games> findByGameDate(LocalDateTime gameDate);

    List<Games> findByGameDateGreaterThanEqualAndGameDateLessThanEqual(LocalDateTime startDate, LocalDateTime endDate);

    List<Games> findByState(String state);
}
