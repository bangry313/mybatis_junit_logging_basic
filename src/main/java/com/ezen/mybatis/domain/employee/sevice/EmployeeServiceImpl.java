package com.ezen.mybatis.domain.employee.sevice;

import com.ezen.mybatis.domain.employee.dto.Employee;
import com.ezen.mybatis.domain.employee.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

// 프리젠테이션 레이어에서 사용 가능한 비즈니스 메서드 제공 (비즈니스 객체)
public class EmployeeServiceImpl {

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
        return sqlSessionFactory;
    }

    // 전체 사원 목록 반환
    public List<Employee> getEmployees(){
        List<Employee> list = null;
        SqlSession sqlSession = null;
        try {
            sqlSession  = getSqlSessionFactory().openSession();
            // Mapper Proxy 객체 반환 받음
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println("반환받은 Proxy 객체 : " + employeeMapper);
            list = employeeMapper.findAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    // 사원 번호에 해당하는 사원 상세 정보 반환
    public Employee getEmployee(int employeeId){
        Employee employee = null;
        SqlSession sqlSession = null;
        try {
            sqlSession  = getSqlSessionFactory().openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employee = employeeMapper.findById(employeeId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
        return employee;
    }

    public static void main(String[] args) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
//        List<Employee> list = employeeService.getEmployees();
//        System.out.println(list);
        Employee employee = employeeService.getEmployee(101);
        System.out.println(employee);
    }

}
