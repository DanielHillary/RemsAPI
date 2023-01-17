package com.jovine.nafa.repository;

import com.jovine.nafa.entity.Standing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandingRepo extends JpaRepository<Standing, Long> {
}
