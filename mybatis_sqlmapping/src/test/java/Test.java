import com.mashibing.bean.Dept;
import com.mashibing.bean.Emp;
import com.mashibing.dao.DeptDao;
import com.mashibing.dao.EmpDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Test {
    private SqlSessionFactory sqlSessionFactory = null;
    private InputStream inputStream = null;
    @Before
    public void init(){
        String resource = "mybatis-config.xml";

        try {
            inputStream = Resources.getResourceAsStream(resource);

        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @org.junit.Test
    public void test1(){

        SqlSession session = sqlSessionFactory.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp = mapper.selectEmpAndDeptByEmpno(7369);
        System.out.println(emp);
        session.close();
    }

    @org.junit.Test
    public void test2(){

        SqlSession session = sqlSessionFactory.openSession();
        DeptDao mapper = session.getMapper(DeptDao.class);
        Dept list = mapper.selectDeptAndEmpByDeptno(20);
        System.out.println(list);
        session.close();
    }

    @org.junit.Test
    public void test3(){
        SqlSession session = sqlSessionFactory.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp = mapper.selectEmpByStep(7369);
        System.out.println(emp);
        session.close();
    }

    @org.junit.Test
    public void test4(){

        SqlSession session = sqlSessionFactory.openSession();
        DeptDao mapper = session.getMapper(DeptDao.class);
        Dept dept = mapper.selectDeptByDeptno2(20);
        System.out.println(dept.getDname());
        session.close();
    }

    @org.junit.Test
    public void test5(){
        SqlSession session = sqlSessionFactory.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(7369);
        emp.setEname("SMITH");
        List list = mapper.selectEmpByCondition(emp);
        System.out.println(list);
        session.close();
    }
    @org.junit.Test
    public void test6(){
        SqlSession session = sqlSessionFactory.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp = new Emp();
        emp.setEmpno(7369);
        emp.setEname("SMITH");
        List list = mapper.selectEmpByDeptnos(Arrays.asList(10,20));
        System.out.println(list);
        session.close();
    }

    @org.junit.Test
    public void test7(){
        SqlSession session = sqlSessionFactory.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp = mapper.selectEmpAndDeptByEmpno(7369);
        System.out.println(emp);
        /**
         * 在同一个会话之内，如果执行了多个相同的sql语句，那么出列第一个之外，所有的数据都是从缓存中进行查询
         *      1，在同一个方法中可能会开启多个会话sqlsession，此时需要注意，会话跟方法没有关系，不是一个方法就只能有一个会话，所以严格记住，缓存的数据是保存在sqlsession中的
         *      2.当传递对象的值不同的时候，也不走缓存
         */
        SqlSession session1 = sqlSessionFactory.openSession();
        EmpDao mapper1 = session1.getMapper(EmpDao.class);
        Emp emp1 = mapper1.selectEmpAndDeptByEmpno(7369);
        System.out.println(emp1);


        session.close();
    }

    Emp emp = new Emp();
    @org.junit.Test
    public void test8(){
        SqlSession session = sqlSessionFactory.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        emp.setEmpno(7369);
        List<Emp> list1 = mapper.selectEmpByCondition(emp);

        System.out.println(list1);
        /**
         * 在同一个会话之内，如果执行了多个相同的sql语句，那么出列第一个之外，所有的数据都是从缓存中进行查询
         *      1，在同一个方法中可能会开启多个会话sqlsession，此时需要注意，会话跟方法没有关系，不是一个方法就只能有一个会话，所以严格记住，缓存的数据是保存在sqlsession中的
         *      2.当传递对象的值不同的时候，也不走缓存
         *      3.在同一个连接中，修改了数据，缓存会失效，不同连接之间不受影响
         *      4.sqlSession.clear();手动清除缓存
         *  二级缓存：表示的是全局缓存，必须要等到
         *
         *
         */

        emp.setEmpno(7340);
        List<Emp> list2 = mapper.selectEmpByCondition(emp);
        System.out.println(list2);

        session.close();
    }


    @org.junit.Test
    public void test9(){
        SqlSession session1 = sqlSessionFactory.openSession();
        SqlSession session2 = sqlSessionFactory.openSession();
        EmpDao mapper1 = session1.getMapper(EmpDao.class);
        EmpDao mapper2 = session2.getMapper(EmpDao.class);
        Emp emp = mapper1.selectEmpAndDeptByEmpno(7369);
        System.out.println(emp);
        System.out.println("=========================");
        emp.setEname("Teacher");
        mapper2.updateEmp(emp);
        //不同的session中，更改了数据，还是从二级缓存中拿数据
        //mapper2中更新，mapper1中两次查询，第二次查询(update后)还是从二级缓存中拿数据
        Emp emp2 = mapper1.selectEmpAndDeptByEmpno(7369);
        System.out.println(emp2);
        //session2.close();
        session1.close();
    }

    @org.junit.Test
    public void test10(){
        SqlSession session = sqlSessionFactory.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp = mapper.selectEmpAndDeptByEmpno(7369);//第一次需要查询数据库， 二级缓存查询命中率Cache Hit Ratio：0  一次查询
        System.out.println(emp);
        session.close();//关闭sqlSession，二级缓存有数据，一级缓存没有数据

        System.out.println("==============================");
        SqlSession session2 = sqlSessionFactory.openSession();
        EmpDao mapper2 = session2.getMapper(EmpDao.class);
        Emp emp2 = mapper2.selectEmpAndDeptByEmpno(7369);//第二次查询数据去二级缓存查询 二级缓存查询命中率Cache Hit Ratio：1/2=0.5
        System.out.println(emp2);
        Emp emp3 = mapper2.selectEmpAndDeptByEmpno(7369);//第三次查询数据去二级缓存查询 二级缓存查询命中率Cache Hit Ratio：2/3=0.666666666
        System.out.println(emp3);
        Emp emp4 = mapper2.selectEmpAndDeptByEmpno(7499);//第四次查询数据去二级缓存查询无数据，去数据库查询 二级缓存查询命中率Cache Hit Ratio：2/4=0.5
        System.out.println(emp4);
        Emp emp5 = mapper2.selectEmpAndDeptByEmpno(7499);//第五次查询数据区二级缓存查询，无数据，sqlSession没有关闭，二级缓存无数据Cache Hit Ratio：2/5=0.4
        System.out.println(emp5);
        Emp emp6 = mapper2.selectEmpAndDeptByEmpno(7499);//第五次查询数据区二级缓存查询，无数据，sqlSession没有关闭，二级缓存无数据Cache Hit Ratio：2/6=0.33333
        System.out.println(emp6);

    }

}
