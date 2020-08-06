package com.example.springbootjpah2demo.service;

import com.example.springbootjpah2demo.domain.Dept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

/**
 * @Description:
 */
public interface DeptService {

    /****************************create*****************************************/
    Dept save(Dept dept);
    /****************************read*****************************************/
    List<Dept> findByAndSort(String deptName, Sort sort);

    Dept findByDeptId(Long deptId);

    Page<Dept> findByLastNameWithPageable(String deptName, Pageable pageable);

    List<Dept> findAllDept(Sort sort);
    /*****************************update****************************************/
    int updateDept(String deptName, Long deptId);
    /*****************************delete****************************************/

    void deleteById(Long deptId);

}