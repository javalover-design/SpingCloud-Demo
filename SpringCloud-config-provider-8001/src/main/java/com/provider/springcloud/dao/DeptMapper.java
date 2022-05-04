package com.provider.springcloud.dao;

import com.example.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Dept mapper.
 *
 * @author lambda  这是一个dept操作数据库的接口类
 */
@Mapper
@Repository
public interface DeptMapper {
    /**
     * Query all dept list.
     *查询所有的部门，返回一个部门的list集合
     * @return the list
     */

  //  @Select("SELECT * FROM DB_API.dept")
    List<Dept> queryAllDept();

    /**
     * Add dept boolean.
     *添加一个部门，最后返回结果的布尔值
     * @param dept the dept
     * @return the boolean
     */
   // @Insert(" INSERT INTO DB_API.dept(dname, db_source) VALUES(#{dname},DATABASE())")
    boolean addDept(Dept dept);

    /**
     * Query dept by id dept.
     *通过id查询一个部门
     * @param id the id
     * @return the dept
     */
   // @Select(" SELECT * FROM DB_API.dept WHERE deptno=#{deptno}")
    Dept queryDeptById(long id);

}
