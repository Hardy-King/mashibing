package com.mashibing.dao;

import com.mashibing.bean.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {
    Emp selectEmpAndDeptByEmpno(Integer empno);
    Emp selectEmpByStep(Integer empno);

    Emp selectEmpByStep2(Integer empno);

    List selectEmpByCondition(Emp emp);


    List<Emp> selectEmpByDeptnos(@Param("deptnos") List<Integer> deptnos);

    void updateEmp(Emp emp);

}
