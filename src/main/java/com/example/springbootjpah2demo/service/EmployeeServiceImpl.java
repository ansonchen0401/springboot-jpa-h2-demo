package com.example.springbootjpah2demo.service;

import com.example.springbootjpah2demo.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


/**
 * @Description:
 */
@Component("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    /**************************create********************************/
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    /**************************read********************************/
    @Override
    public List<Employee> findByAndSort(String empName, Sort sort) {
        return employeeRepository.findByAndSort(empName, sort);
    }

    @Override
    public Employee findByEmpId(String empId) {
        return employeeRepository.findByEmpId(empId);
    }

    @Override
    public Page<Employee> findByNameWithPageable(String empName, Pageable pageable) {
        return employeeRepository.findByNameWithPageable(empName, pageable);
    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return employeeRepository.findAll(sort);
    }


//    public Result getTestUsersByExtendDao(){
//        List<TestUser> list = testUserExtendDao.getTestUserInfo(20, "", 170);//通過兩個條件，string設為空
//        printTestUserInfo(list);
//        return new Result("查詢成功！", list);
//    }

    /**************************update********************************/
//    @Override
//    public int updateEmployee(String empName, LocalDateTime updateTime, String empId) {
//        return employeeRepository.updateEmployee(empName, updateTime, empId);
//    }
    @Override
    public int updateEmployee(String empName, String empId) {
        return employeeRepository.updateEmployee(empName, empId);
    }
    /**************************delete********************************/
    @Override
    public void deleteByEmpId(String empId) {
        employeeRepository.deleteByEmpId(empId);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

}