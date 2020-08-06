package com.example.springbootjpah2demo.controller;

import com.example.springbootjpah2demo.domain.Employee;
import com.example.springbootjpah2demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


/**
 * @Description:
 * POST - Create a new resource
 * GET - Read a resource
 * PUT - Update an existing resource
 * DELETE - Delete a resource
 * Tomcat by default is not enabled for HTTP PUT command.
 * 只要让地址栏的参数可以传入函数里面，就能执行修改、新增、删除操作，method用RequestMethod.GET即可
 * 用PUT、POST、DELETE会报405错误，因为输入到地址栏默认使用GET方法
 * 注解@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)主要是解决请求日期无法转成LocalDate的问题
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    /*****************************create*************************************/
    @RequestMapping(value = "/save/{empName}/{empId}/{depId}/{gender}/{tel}/{addr}/{age}",method = RequestMethod.GET)
    @Transactional
    public Employee save(@PathVariable String empName,
                         @PathVariable String empId,
                         @PathVariable String depId,
                         @PathVariable String gender,
                         @PathVariable String tel,
                         @PathVariable String addr,
                         @PathVariable String age
                        ){
        Employee employee = new Employee();//Id是自增长的，不需要传
        employee.setEmpName(empName);
        employee.setEmpId(empId);
        employee.setDepId(depId);
        employee.setGender(gender);
        employee.setTel(tel);
        employee.setAddr(addr);
        employee.setAge(age);
//        employee.setCreateTime(new Date(System.currentTimeMillis()));
//        employee.setUpdateTime(new Date(System.currentTimeMillis()));
        return employeeService.save(employee);
    }

    /*****************************Read***** ********************************/
    @RequestMapping(value = "/findByAndSort/{empName}", method = RequestMethod.GET)
    public List<Employee> findByAndSort(@PathVariable String empName) {
        Sort sort = Sort.by(Sort.Direction.DESC, "empName");
        return employeeService.findByAndSort(empName, sort);
    }

    @RequestMapping(value = "/findByEmpId/{empId}", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public Employee findByEmpId(@PathVariable(name = "empId")  String empId) {
        return employeeService.findByEmpId(empId);
    }

    @RequestMapping(value = "/findByLastNameWithPageable/{empName}", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public Page<Employee> findByLastNameWithPageable(@PathVariable String empName) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(5,2, sort);
        return employeeService.findByNameWithPageable(empName, pageable);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Employee> findAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return employeeService.findAll(sort);
    }
    /*****************************update*************************************/
    @RequestMapping(value = "/updateEmployee/{empName}/{empId}", method = RequestMethod.GET)
    public int updateEmployee(@PathVariable String empName, @PathVariable String empId) {
        return employeeService.updateEmployee(empName/*, LocalDateTime.now()*/, empId);
    }
    /*****************************delete*************************************/
    @RequestMapping(value = "/deleteByEmpId/{empId}", method = RequestMethod.GET)
    @Transactional
    public String deleteByEmpId(@PathVariable String empId) {
        employeeService.deleteByEmpId(empId);
        return "SUCCESS";
    }

    @RequestMapping(value = "/deleteById/{id}", method = RequestMethod.GET)
    @Transactional
    public String deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "SUCCESS";
    }

}