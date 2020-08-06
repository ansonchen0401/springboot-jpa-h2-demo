package com.example.springbootjpah2demo.service;


import com.example.springbootjpah2demo.domain.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @Description:
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{


    @PersistenceContext//@[email protected]
    EntityManager em = null;


    /******************************create***************************************/
    @Override
    Employee save(Employee employee);
    /******************************read***************************************/
    /**
     * Using sort
     * @param empName
     * @param sort
     * @return
     */
    @Query("select u from Employee u where u.empName like ?1%")
    List<Employee> findByAndSort(String empName, Sort sort);

    /**
     * Query creation
     * this translates into the following query:
     * select u from User u where u.idCard = ?1
     */
    Employee findByEmpId(String empId);

    /**
     * Declare native count queries for pagination at the query method by using @Query
     * @param empName
     * @param pageable
     * @return
     */
    @Query(value = "SELECT * FROM Employee WHERE empName = ?1",
            countQuery = "SELECT count(*) FROM Employee WHERE NAME = ?1",
            nativeQuery = true)
    Page<Employee> findByNameWithPageable(String empName, Pageable pageable);

    /**
     * find all Employee
     * @param sort
     * @return
     */
    @Override
    List<Employee> findAll(Sort sort);


//
//    @SuppressWarnings("unused")
//    public List<Employee> getTestUserInfo(final Integer age, final String name, final Integer high){
//        //1
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        //2
//        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
//
//        //3
//        //from
//        Root<Employee> root = query.from(Employee.class);
//
//        //4
//        //where
//        Predicate p1 = null;
//        if (age != 0) {
//            System.out.println("正在操作age！！！");
//            Predicate p2 = cb.equal(root.get(Employee.), age);
//            if (p1 != null) {
//                p1=cb.and(p1, p2);
//            } else {
//                p1 = p2;
//            }
//        }
//        if (false==name.isEmpty()) {
//            System.out.println("正在操作name！！！");
//            Predicate p2 = cb.equal(root.get(TestUser_.userName), name);
//            if (p1 != null) {
//                p1=cb.and(p1, p2);
//            } else {
//                p1 = p2;
//            }
//        }
//        if (high != 0) {
//            System.out.println("正在操作high！！！");
//            Predicate p2 = cb.equal(root.get(TestUser_.high), high);
//            if (p1 != null) {
//                p1=cb.and(p1, p2);
//            } else {
//                p1 = p2;
//            }
//        }
//        //5
//        query.where(p1);
//        //6
//        List<TestUser> testUsers = em.createQuery(query).getResultList();
//        return testUsers;
//    }
//


    /****************************update*****************************************/
    /**
     * update a usr by Modifying Queries
     * @param empName
     * @param empId
     * @return
     */
//    @Modifying
//    @Query("update Employee u set u.empName = ?1, u.updateTime = ?2 where u.empId = ?3")
//    int updateEmployee(String empName, LocalDateTime updateTime, String empId );

    @Modifying
    @Query("update Employee u set u.empName = ?1 where u.empId = ?2")
    int updateEmployee(String empName, String empId );
    /****************************delete*****************************************/
    /**
     * delete a user by empId
     * @param empId
     */
    void deleteByEmpId(String empId);

    /**
     * delete a user by id
     * @param id
     */
    @Override
    @Modifying
    @Query(value = "delete from Employee where id = ?1", nativeQuery = true)
    void deleteById(Long id);

}