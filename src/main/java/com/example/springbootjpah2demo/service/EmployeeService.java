package com.example.springbootjpah2demo.service;

import com.example.springbootjpah2demo.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:
 */
public interface EmployeeService {

    /****************************create*****************************************/
    Employee save(Employee employee);
    /****************************read*****************************************/
    List<Employee> findByAndSort(String empName, Sort sort);

    Employee findByEmpId(String empId);

    Page<Employee> findByNameWithPageable(String empName, Pageable pageable);

    List<Employee> findAll(Sort sort);

//    public Result getTestUsersByExtendDao();
    /*****************************update****************************************/
//    int updateEmployee(String name, LocalDateTime updateTime, String empId);
    int updateEmployee(String name, String empId);
    /*****************************delete****************************************/
    void deleteByEmpId(String empId);

    void deleteById(Long id);

}