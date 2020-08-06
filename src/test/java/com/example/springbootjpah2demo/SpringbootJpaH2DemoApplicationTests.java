package com.example.springbootjpah2demo;

import com.example.springbootjpah2demo.domain.Dept;
import com.example.springbootjpah2demo.domain.Employee;
import com.example.springbootjpah2demo.service.DeptService;
import com.example.springbootjpah2demo.service.EmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class SpringbootJpaH2DemoApplicationTests {

    //先普通的注入一個Service
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DeptService deptService;

    @Test
    public void getByAndSort() throws Exception {
        Sort sort = Sort.by(Sort.Direction.DESC, "empName");
        List<Employee> employee = employeeService.findByAndSort("1", sort);
        //檢查結果
        Assert.assertNull("資料不存在",employee);
    }
    @Test
    public void getUserById() throws Exception {
        Employee employee = employeeService.findByEmpId("1");
        //檢查結果
        Assert.assertNull("資料不存在",employee);
    }
    @Test
    public void getByNameWithPageable() throws Exception {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(5,2, sort);
        Page<Employee> employee = employeeService.findByNameWithPageable("1",pageable);
        //檢查結果
        Assert.assertNull("資料不存在",employee);
    }
    @Test
    public void getAll() throws Exception {
        Sort sort = Sort.by(Sort.Direction.DESC, "empName");
        List<Employee> employee = employee = employeeService.findAll(sort);
        //檢查結果
        Assert.assertNull("資料不存在",employee);
    }
    @Test
    public void updateEmployee() throws Exception {
        int employee = employeeService.updateEmployee("1","1");
        //檢查結果
        Assert.assertNull("資料不存在",employee);

    }

    @Test
    public void deleteByEmpId() throws Exception {
        employeeService.deleteByEmpId("1");
        //檢查結果

    }

    @Test
    public void getByAndSortDept() throws Exception {
        Sort sort = Sort.by(Sort.Direction.DESC, "deptName");
        List<Dept> employee = deptService.findByAndSort("1", sort);
        //檢查結果
        Assert.assertNull("資料不存在",employee);
    }
    @Test
    public void getUserByIdDept() throws Exception {
        Dept dept = deptService.findByDeptId(Long.valueOf("1"));
        //檢查結果
        Assert.assertNull("資料不存在",dept);
    }
    @Test
    public void getByNameWithPageableDept() throws Exception {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(5,2, sort);
        Page<Dept> dept = deptService.findByLastNameWithPageable("1",pageable);
        //檢查結果
        Assert.assertNull("資料不存在",dept);
    }
    @Test
    public void getAllDept() throws Exception {
        Sort sort = Sort.by(Sort.Direction.DESC, "deptName");
        List<Dept> dept = deptService.findAllDept(sort);
        //檢查結果
        Assert.assertNull("資料不存在",dept);
    }
    @Test
    public void updateDept() throws Exception {
        int employee = deptService.updateDept("1",Long.valueOf("1"));
        //檢查結果
        Assert.assertNull("資料不存在",employee);

    }

    @Test
    public void deleteByEmpIdDept() throws Exception {
        deptService.deleteById(Long.valueOf("01"));
        //檢查結果

    }


}
