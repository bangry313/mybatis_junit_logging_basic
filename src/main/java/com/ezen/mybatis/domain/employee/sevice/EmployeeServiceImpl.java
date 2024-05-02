package com.ezen.mybatis.domain.employee.sevice;

import com.ezen.mybatis.domain.employee.dto.Employee;
import com.ezen.mybatis.domain.employee.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 급여 범위로 사원 조회
    public List<Employee> getEmployeesBySaley(Map<String, Integer> params){
        List<Employee> list = null;
        SqlSession sqlSession = null;
        try {
            sqlSession  = getSqlSessionFactory().openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            list = employeeMapper.findBySalaryRange(params);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    // 급여 범위로 사원 조회
    public List<Employee> getEmployeesBySaley2(int min, int max){
        List<Employee> list = null;
        SqlSession sqlSession = null;
        try {
            sqlSession  = getSqlSessionFactory().openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            list = employeeMapper.findBySalaryRange2(min, max);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    // 부서명 포함 사원상세정보 조회
    public List<Map<String, Object>> getEmployeesByJoin(){
        List<Map<String, Object>> list = null;
        SqlSession sqlSession = null;
        try {
            sqlSession  = getSqlSessionFactory().openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            list = employeeMapper.findByJoin();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    // 사원 급여 정보 수정
    public void updateSalary(int employeeId, int salary){
        SqlSession sqlSession = null;
        try {
            sqlSession  = getSqlSessionFactory().openSession(false);
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = new Employee();
            employee.setId(employeeId);
            employee.setSalary(salary);
            employeeMapper.update(employee);
            sqlSession.commit();
        } catch (IOException e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }


    public static void main(String[] args) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
//        List<Employee> list = employeeService.getEmployees();
//        System.out.println(list);
        Employee employee = employeeService.getEmployee(100);
        System.out.println(employee);
//        Map<String, Integer> params = new HashMap<>();
//        params.put("min", 2000);
//        params.put("max", 3000);
//        List<Employee> list = employeeService.getEmployeesBySaley2(2000, 3000);
//        System.out.println(list);
//        System.out.println(employeeService.getEmployeesByJoin());

//        employeeService.updateSalary(100, 500);
//        System.out.println("수정 완료...");
    }

}
