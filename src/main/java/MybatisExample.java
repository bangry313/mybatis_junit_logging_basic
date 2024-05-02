import com.ezen.mybatis.domain.employee.dto.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Member;
import java.util.List;

public class MybatisExample {
    private static final String NAMESPACE = "com.ezen.mybatis.domain.employee.dao.EmployeeDao";

    public static void main(String[] args) throws IOException {
        // 마이바티스 설정 파일 패스
        String resource = "mybatis/mybatis-config.xml";

        Reader reader = Resources.getResourceAsReader(resource);
        // 빌더패턴이 적용된 API

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "product");

        // 오토커밋 설정
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 노 오토커밋
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
//        sqlSession.commit();
//        sqlSession.rollback();



        System.out.println("오라클 연결됨...");

//        List<Employee> list = sqlSession.selectList(NAMESPACE + ".findAll");
//        for (Employee employee : list) {
//            System.out.println(employee);
//        }

//        Employee findEmployee = sqlSession.selectOne(NAMESPACE + ".findById", 100);
//        System.out.println(findEmployee);

        int salary= sqlSession.selectOne(NAMESPACE + ".findBySalary", 100 );
        System.out.println(salary);

        sqlSession.close();



    }
}










