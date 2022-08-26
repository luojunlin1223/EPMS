package com.epms.epms.service;

import com.epms.epms.model.entity.Position;

import java.util.List;
import java.util.Optional;

public interface PositionService {
    List<Position> findAll();
    Position save(Position department);
    void deleteById(Long id);
    Position update(Long id,Position position);
    Optional<Position> findById(Long id);
}
