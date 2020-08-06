package com.example.springbootjpah2demo.service;

import com.example.springbootjpah2demo.domain.Dept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Description:
 */
@Component("userService")
@Transactional
public class DeptServiceImpl implements DeptService {
    private DeptRepository deptRepository;

    DeptServiceImpl(DeptRepository deptRepository) {
        this.deptRepository = deptRepository;
    }
    /**************************create********************************/
    @Override
    public Dept save(Dept dept) {
        return deptRepository.save(dept);
    }
    /**************************read********************************/
    @Override
    public List<Dept> findByAndSort(String deptName, Sort sort) {
        return deptRepository.findByAndSort(deptName, sort);
    }

    @Override
    public Dept findByDeptId(Long deptId) {
        return deptRepository.findByDeptId(deptId);
    }

    @Override
    public Page<Dept> findByLastNameWithPageable(String deptName, Pageable pageable) {
        return deptRepository.findByLastNameWithPageable(deptName, pageable);
    }

    @Override
    public List<Dept> findAllDept(Sort sort) {
        return deptRepository.findAll(sort);
    }

    /**************************update********************************/
    @Override
    public int updateDept(String deptName, Long deptId) {
        return deptRepository.updateDept(deptName, deptId);
    }
    /**************************delete********************************/
    @Override
    public void deleteById(Long deptId) {
        deptRepository.deleteById(deptId);
    }


}