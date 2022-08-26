package com.epms.epms.service;

import com.epms.epms.model.dao.PositionDao;
import com.epms.epms.model.entity.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionServiceImpl implements PositionService{
    @Autowired
    PositionDao positionDao;
    @Override
    public List<Position> findAll() {
        return positionDao.findAll();
    }

    @Override
    public Position save(Position position) {
        return positionDao.save(position);
    }

    @Override
    public void deleteById(Long id) {
        positionDao.deleteById(id);
    }

    @Override
    public Position update(Long id, Position position) {
        return positionDao.save(position);
    }

    @Override
    public Optional<Position> findById(Long id) {
        return positionDao.findById(id);
    }
}
