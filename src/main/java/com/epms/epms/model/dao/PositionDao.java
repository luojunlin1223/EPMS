package com.epms.epms.model.dao;

import com.epms.epms.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position,Long> {
}
