package com.jovine.nafa.repository;

import com.jovine.nafa.entity.GroupClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepo extends JpaRepository<GroupClass, Long> {
}
