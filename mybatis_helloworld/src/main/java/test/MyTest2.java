package test;

import com.mashibing.bean.Dog;
import com.mashibing.bean.Emp;
import com.mashibing.dao.DogDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest2 {
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
        DogDao mapper = session.getMapper(DogDao.class);
        List<Dog> dogs = mapper.selectAll();
        for (Dog dog : dogs) {
            System.out.println(dog);
        }

        session.close();
    }

}
