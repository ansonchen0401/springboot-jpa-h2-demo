package com.example.springbootjpah2demo.controller;

import com.example.springbootjpah2demo.domain.Dept;
import com.example.springbootjpah2demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class DeptController {

    @Autowired
    private DeptService deptService;
    /*****************************create*************************************/
    @RequestMapping(value = "/saveUser/{deptId}/{deptName}",method = RequestMethod.GET)
    @Transactional
    public Dept saveUser(@PathVariable Long deptId,
                         @PathVariable String deptName) {
        Dept dept = new Dept();
        dept.setDeptId(deptId);
        dept.setDeptName(deptName);
        return deptService.save(dept);
    }

    /*****************************Read***** ********************************/
    @RequestMapping(value = "/findByAndSort/{deptName}", method = RequestMethod.GET)
    public List<Dept> findByAndSort(@PathVariable String deptName) {
        Sort sort = Sort.by(Sort.Direction.DESC, "deptName");
        return deptService.findByAndSort(deptName, sort);
    }

    @RequestMapping(value = "/findByDeptId/{deptId}", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public Dept findByDeptId(@PathVariable(name = "deptId")  Long deptId) {
        return deptService.findByDeptId(deptId);
    }

    @RequestMapping(value = "/findByLastNameWithPageable/{deptName}", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public Page<Dept> findByLastNameWithPageable(@PathVariable String deptName) {
        Sort sort = Sort.by(Sort.Direction.DESC, "deptId");
        Pageable pageable = PageRequest.of(5,2, sort);
        return deptService.findByLastNameWithPageable(deptName, pageable);
    }

    @RequestMapping(value = "/findAllDept", method = RequestMethod.GET)
    public List<Dept> findAllDept() {
        Sort sort = Sort.by(Sort.Direction.ASC, "deptId");
        return deptService.findAllDept(sort);
    }
    /*****************************update*************************************/
    @RequestMapping(value = "/updateUser/{deptName}/{deptId}", method = RequestMethod.GET)
    public int updateDept(@PathVariable String deptName, @PathVariable Long deptId) {
        return deptService.updateDept(deptName, deptId);
    }
    /*****************************delete*************************************/

    @RequestMapping(value = "/deleteById/{deptId}", method = RequestMethod.GET)
    @Transactional
    public String deleteById(@PathVariable Long deptId) {
        deptService.deleteById(deptId);
        return "SUCCESS";
    }

}