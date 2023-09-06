package com.jovine.rems.repository;

import com.jovine.rems.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByState(String state);

    void deleteByState(String state);
}
