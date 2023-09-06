package com.jovine.rems.repository;

import com.jovine.rems.entity.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {
    List<Lease> findByState(String state);
}
