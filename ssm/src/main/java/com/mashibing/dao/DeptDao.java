package com.mashibing.dao;

import com.mashibing.bean.Dept;

public interface DeptDao {
    Dept selectDeptAndEmpByDeptno(Integer deptno);

    Dept selectDeptByDeptno(Integer deptno);

    Dept selectDeptByDeptno2(Integer deptno);
}
