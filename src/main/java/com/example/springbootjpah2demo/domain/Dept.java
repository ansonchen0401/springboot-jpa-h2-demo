package com.example.springbootjpah2demo.domain;


import javax.persistence.*;
import java.io.Serializable;


/**
 * @Description: SpringBoot自动配置会探测到我们使用了H2数据库，它会根据实体类自动创建数据表
 */
@Entity
@Table(name = "Dept")
public class Dept implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private Long deptId;//部門ID

    @Column(nullable = false)
    private String deptName;//部門名稱

    public Dept() {
    }

    public Dept(Long deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;

    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}
