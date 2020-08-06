package com.example.springbootjpah2demo.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description: SpringBoot自动配置会探测到我们使用了H2数据库，它会根据实体类自动创建数据表
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Employee")
public class Employee implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//主键

    @Column(nullable = false)
    private String empName;//姓名

    @Column(nullable = false)
    private String empId;//員工編號

    @Column(nullable = false)
    private String depId;//部門ID

    @Column(nullable = false)
    private String gender;//性別

    @Column(nullable = false)
    private String tel;//電話

    @Column(nullable = false)
    private String addr;//地址

    @Column(nullable = false)
    private String age;//年齡

    @CreatedDate
    @Column(nullable = false)
    private Date createTime;//建立時間

    @LastModifiedDate
    @Column(nullable = false)
    private Date updateTime;//最後一次修改時間

    public Employee() {
    }

    public Employee(String empName, String empId, String depId, String gender, String tel, String addr,
                    String age, Date createTime, Date updateTime) {

        this.empName = empName;
        this.empId = empId;
        this.depId = depId;
        this.gender = gender;
        this.tel = tel;
        this.addr = addr;
        this.age = age;
        this.createTime = createTime;
        this.updateTime = updateTime;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String name) {
        this.empName = empName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + empName + '\'' +
                ", empId='" + empId + '\'' +
                ", depId='" + depId + '\'' +
                ", gender=" + gender +
                ", tel='" + tel + '\'' +
                ", addr='" + addr + '\'' +
                ", age=" + age +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }
}
