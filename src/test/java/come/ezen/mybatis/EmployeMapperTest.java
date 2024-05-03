package come.ezen.mybatis;

import com.ezen.mybatis.domain.employee.dto.Employee;
import com.ezen.mybatis.domain.employee.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@Slf4j
public class EmployeMapperTest {

    static SqlSessionFactory sqlSessionFactory = null;

    @BeforeAll
    static void setUp(){
        String resource = "mybatis/mybatis-config.xml";
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void findAllTest(){
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> list  = employeeMapper.findAll();
        for (Employee employee : list) {
            log.info("{}", employee);
        }
    }

    @Test
    void findByIdTest(){
        SqlSession sqlSession  = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee  = employeeMapper.findById(100);
        log.info("{}", employee);
    }
}
