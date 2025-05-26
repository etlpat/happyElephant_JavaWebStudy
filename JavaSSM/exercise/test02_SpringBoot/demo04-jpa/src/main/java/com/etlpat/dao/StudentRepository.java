package com.etlpat.dao;

import com.etlpat.pojo.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


// (1)JPA自定义查询方法名
//  一、基本命名规则
//      JPA 方法名由 查询主题(Subject) + 断言(Predicate) 组成，格式为：
//          [查询动作][By|And|Or|OrderBy][属性名][条件][排序方向]
//
//  二、常用查询动作
//      关键字	示例	                        生成的查询
//      find	findByLastName	            查询符合条件的记录
//      read	readByFirstName	            同 find
//      get	    getByEmail	                同 find
//      query	queryByAge	                同 find
//      count	countByStatus	            统计符合条件的记录数
//      exists	existsByName	            检查是否存在符合条件的记录
//      delete	deleteByCreateDateBefore	删除符合条件的记录
//
//  三、条件表达式
//  1. 基本比较
//      关键字	    示例	                    生成的 SQL 条件
//      Is/Equals	findByNameIs	        name = ?1
//                  findByNameEquals	    name = ?1
//      Not	        findByNameNot	        name <> ?1
//      IsNull	    findByAddressIsNull	    address is null
//      IsNotNull	findByEmailIsNotNull	email is not null
//  2. 相似匹配
//      关键字	        示例	                    生成的 SQL 条件
//      Like	        findByNameLike	        name like ?1
//      NotLike	        findByNameNotLike	    name not like ?1
//      StartingWith	findByNameStartingWith	name like ?1%
//      EndingWith	    findByNameEndingWith	name like %?1
//      Containing	    findByNameContaining	name like %?1%
//  3. 数值比较
//      关键字	            示例	                        生成的 SQL 条件
//      LessThan	        findByAgeLessThan	        age < ?1
//      LessThanEqual	    findByAgeLessThanEqual	    age <= ?1
//      GreaterThan	        findByAgeGreaterThan	    age > ?1
//      GreaterThanEqual	findByAgeGreaterThanEqual	age >= ?1
//      Between	            findByAgeBetween	        age between ?1 and ?2
//  4. 日期比较
//      关键字	示例	                    生成的 SQL 条件
//      Before	findByCreateDateBefore	create_date < ?1
//      After	findByCreateDateAfter	create_date > ?1
//  5. 集合操作
//      关键字	    示例	                    生成的 SQL 条件
//      In	        findByStatusIn	        status in ?1
//      NotIn	    findByStatusNotIn	    status not in ?1
//      True	    findByActiveTrue	    active = true
//      False	    findByActiveFalse	    active = false
//      Empty	    findByRolesEmpty	    roles is empty
//      NotEmpty	findByRolesNotEmpty	    roles is not empty
//
//  四、组合条件
//      使用 And 和 Or 连接多个条件：
//          AND 连接
//              List<User> findByLastNameAndFirstName(String lastName, String firstName);
//          OR 连接
//              List<User> findByLastNameOrFirstName(String lastName, String firstName);
//          复杂组合
//              List<User> findByStatusAndAgeBetweenOrNameContaining(String status, int ageStart, int ageEnd, String namePart);
//
//
//
// (2)JPQL
//  使用Spring Data JPA提供的查询方法已经可以解决大部分的应用场景,但是对于某些业务来说,我们还需要灵活的构造查询条件,
//  这时就可以使用@Query注解,结合JPQL的语句方式完成查询。
//
//  @Query注解的使用非常简单,只需在方法上面标注该注解,同时提供一个JPQL查询语句即可,注意:
//      ~大多数情况下将*替换为别名
//      ~表名改为类名
//      ~字段名改为属性名
//      ~搭配注解@Query进行使用
//  e.g.
//      @Query("select 表别名 from 表名(实际为类名) 别名 where 别名.属性='xxx'")
//      public List<Students> findStudents();
//


@Repository
// 让自定义的myRepository接口继承JpaRepository接口，其泛型为<表的实体类, 主键id的类型>
public interface StudentRepository extends JpaRepository<Students, Integer> {

    // (1)使用方法名定义sql语句============================================================================================
    // 根据用户名查询
    // 【注意：只要按照规范定义方法名，jpa会自动生成方法名对应的sql语句！】
    List<Students> findAllByName(String name);

    // 根据性别和地址查询
    List<Students> findAllByGenderAndAddress(String gender, String address);

    // 根据姓名模糊查询
    List<Students> findAllByNameLike(String name);


    // (2)JPQL==========================================================================================================
    // 查询全部用户
    @Query("select s from Students s")
    // 注意：JPQL规则下，Student为类名，而非表名
    List<Students> findAllStudents();// 自定义JPQL，则方法名随意

    // 查询全部用户的id
    @Query("select s.id from Students s")
    List<Integer> findAllStudentsId();

    // 查询指定名称的用户
    // 注意：①若想JPQL语句中使用参数，参数必须添加 @Param("xxx") 注解！
    //      ②解析：where s.name = :name
    //          -由于JPQL是基于对象的语句，因此前者需要写为 s.name
    //          -由于后者是参数中的@Param属性，因此固定写为 :name
    @Query("select s from Students s where s.name = :name")
    List<Students> findStudentsByName(@Param("name") String name);

    // 查询某状态的人数
    @Query("select count(s) from Students s where s.status = :status")
    Integer findNumOfStudentsStatus(@Param("status") Integer status);

    // 根据姓名修改状态
    // 注意：①若参数不用@Param注解，还可以用占位符。 ?1 表示第一个参数，?2 表示第二个参数。
    //      ②修改时必须添加注解：@Transactional、@Modifying
    @Transactional
    @Modifying
    @Query("update Students s set s.status = ?2 where s.name = ?1")
    Integer updateStatusByName(String name, Integer status);
}
