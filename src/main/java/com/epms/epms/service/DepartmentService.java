package com.epms.epms.service;


import com.epms.epms.model.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> findAll();
    Department save(Department department);
    void deleteById(Long id);
    Department update(Long id,Department department);
    Optional<Department> findById(Long id);
}
