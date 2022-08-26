package com.epms.epms.service;

import com.epms.epms.model.dao.DepartmentDao;
import com.epms.epms.model.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmenServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentDao departmentDao;


    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public Department save(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public void deleteById(Long id) {
        if(departmentDao.existsById(id)){
            departmentDao.deleteById(id);
        }
    }

    @Override
    public Department update(Long id, Department department) {
        return departmentDao.save(department);
    }

    @Override
    public Optional<Department> findById(Long id) {
        return departmentDao.findById(id);
    }


}
