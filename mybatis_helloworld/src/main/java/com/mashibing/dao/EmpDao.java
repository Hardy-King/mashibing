package com.mashibing.dao;

import com.mashibing.bean.Emp;
import com.mashibing.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmpDao {
    //@Insert("insert into emp(empno,ename) values(#{empno}),#{ename}")
    public Integer save(Emp emp);
    public Integer update(Emp emp);
    public Integer delete(Integer empno);

    public Emp selectEmpByEmpno(int empNo);

    //当返回结果是map结构的时候，会把查询的结果的字段值作为key，结果作为value
    public Map<Object,Object> selectEmpByEmpnoReturnMap(int empNo);

    @MapKey("ename")
    Map<String,Emp> selectAll2();

    public Emp selectEmpByEmpnoandTableName(String tablename,int empno);

    public List<Emp> selectEmpByEmpnoandSal(@Param("empno") int empno, @Param("sal") double sal);


    public List<Emp> selectEmpByEmpnoandSal3(Map<String,Object> map);

    List<User> selectAll();


}
