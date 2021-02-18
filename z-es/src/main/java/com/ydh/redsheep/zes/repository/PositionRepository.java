package com.ydh.redsheep.zes.repository;

import com.ydh.redsheep.zes.pojo.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position,Integer> {
}
