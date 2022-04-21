package com.provider.springcloud.service;

import com.example.springcloud.pojo.Dept;
import com.provider.springcloud.dao.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lambda
 */
@Service
public class DeptServiceImpl implements DeptService{


    private DeptMapper deptMapper;
    @Autowired
    public DeptServiceImpl(DeptMapper deptMapper) {
        this.deptMapper = deptMapper;
    }

    @Override
    public List<Dept> queryAllDept() {
        return deptMapper.queryAllDept();
    }

    @Override
    public boolean addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept queryDeptById(long id) {
        return deptMapper.queryDeptById(id);
    }
}
