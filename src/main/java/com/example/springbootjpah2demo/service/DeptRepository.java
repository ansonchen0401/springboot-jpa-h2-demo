package com.example.springbootjpah2demo.service;


import com.example.springbootjpah2demo.domain.Dept;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


/**
 * @Description:
 */
public interface DeptRepository extends JpaRepository<Dept, Long>{

    /******************************create***************************************/
    @Override
    Dept save(Dept dept);
    /******************************read***************************************/
    /**
     * Using sort
     * @param deptName
     * @param sort
     * @return
     */
    @Query("select u from Dept u where u.deptName like ?1%")
    List<Dept> findByAndSort(String deptName, Sort sort);

    /**
     * Query creation
     * this translates into the following query:
     * select u from User u where u.idCard = ?1
     */
    Dept findByDeptId(Long deptId);

    /**
     * Declare native count queries for pagination at the query method by using @Query
     * @param deptName
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM Dept WHERE deptName = ?1",
            countQuery = "SELECT count(*) FROM Dept WHERE deptName = ?1",
            nativeQuery = true)
    Page<Dept> findByLastNameWithPageable(String deptName, Pageable pageable);


    /**
     * find all users
     * @param sort
     * @return
     */
    @Override
    List<Dept> findAll(Sort sort);
    /****************************update*****************************************/
    /**
     * update a usr by Modifying Queries
     * @param deptName
     * @param deptId
     * @return
     */
    @Modifying
    @Query("update Dept u set u.deptName = ?1 where u.deptId = ?2")
    int updateDept(String deptName, Long deptId);
    /****************************delete*****************************************/
    /**
     * delete a Dept by deptId
     * @param deptId
     */
    @Override
    @Modifying
    @Query(value = "delete from Dept where deptId = ?1", nativeQuery = true)
    void deleteById(Long deptId);

}