package test;

import com.mashibing.bean.Emp;
import com.mashibing.bean.User;
import com.mashibing.dao.EmpDao;
import com.mashibing.dao.UserDao;
import com.mashibing.dao.UserDaoAnno;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
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

    @Test
    public void test1(){

        SqlSession session = sqlSessionFactory.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp = mapper.selectEmpByEmpno(7369);
        System.out.println(emp);
        /*Emp emp1 = new Emp();
        emp1.setEname("zhangsan");
        emp1.setEmpno(1232);
        Integer save = mapper.save(emp1);
        System.out.println(save);
        session.commit();*/
        session.close();
    }
    @Test
    public void test2(){


        SqlSession session = sqlSessionFactory.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp1 = new Emp();
        emp1.setEname("tianqi");
        emp1.setEmpno(333344);
        Integer save = mapper.save(emp1);
        System.out.println(save);
        System.out.println(emp1);
        session.commit();
        session.close();
    }
    @Test
    public void test3(){

        SqlSession session = sqlSessionFactory.openSession();
        EmpDao mapper = session.getMapper(EmpDao.class);
        Emp emp1 = new Emp();
        emp1.setEname("haiyang1");
        emp1.setEmpno(3333);
        Integer save = mapper.update(emp1);
        System.out.println(save);
        session.commit();
        session.close();
    }

    @Test
    public void test5(){

        SqlSession session = sqlSessionFactory.openSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.findUserById(1);
        System.out.println(user);
        session.close();
    }

    @Test
    public void test6(){

        SqlSession session = sqlSessionFactory.openSession();
        UserDaoAnno mapper = session.getMapper(UserDaoAnno.class);
        User emp = mapper.findUserById(1);
        System.out.println(emp);
        session.close();
    }


    @Test
    public void test7(){

        SqlSession session = sqlSessionFactory.openSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = new User();
        user.setUserName("wangzherongyao2");
        Integer save = mapper.save(user);
        System.out.println(save);
        /**
         * 此处直插入了ename，但是id是自增的，直接打印是无法直接显示id的
         */
        System.out.println(user);
        session.commit();
        session.close();
    }
    @Test
    public void test8(){

        SqlSession session = sqlSessionFactory.openSession();
        UserDao ud = session.getMapper(UserDao.class);
        List<User> users = ud.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();
    }
    @Test
    public void test9(){

        SqlSession session = sqlSessionFactory.openSession();
        EmpDao ed = session.getMapper(EmpDao.class);
        /*Emp emp = ed.selectEmpByEmpnoandTableName("emp", 7369);
        System.out.println(emp);*/
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("empno",7369);
        map.put("sal",500);
        List<Emp> emps = ed.selectEmpByEmpnoandSal(7369, 500.0);
        for (Emp emp : emps) {
            System.out.println(emp);
        }

        List<Emp> emps1 = ed.selectEmpByEmpnoandSal3(map);
        for (Emp emp : emps1) {
            System.out.println(emp);
        }

        session.close();
    }

    @Test
    public void test10() {

        SqlSession session = sqlSessionFactory.openSession();
        EmpDao ed = session.getMapper(EmpDao.class);
        Map<Object, Object> objectObjectMap = ed.selectEmpByEmpnoReturnMap(7369);
        System.out.println(objectObjectMap);
    }

    @Test
    public void test11() {

        SqlSession session = sqlSessionFactory.openSession();
        EmpDao ed = session.getMapper(EmpDao.class);
        Map<String, Emp> stringEmpMap = ed.selectAll2();
        System.out.println(stringEmpMap);
    }
}
