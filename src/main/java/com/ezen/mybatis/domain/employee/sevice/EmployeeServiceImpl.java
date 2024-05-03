package com.ezen.mybatis.domain.employee.sevice;

import com.ezen.mybatis.domain.common.SqlSessionFactoryBean;
import com.ezen.mybatis.domain.employee.dto.Employee;
import com.ezen.mybatis.domain.employee.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;
import java.util.Map;

// 프리젠테이션 레이어에서 사용 가능한 비즈니스 메서드 제공 (비즈니스 객체)
public class EmployeeServiceImpl {

    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryBean.getInstance().getSqlSessionFactory();

    // 전체 사원 목록 반환
    public List<Employee> getEmployees(){
        List<Employee> list = null;
        SqlSession sqlSession = null;
        try {
            sqlSession  = sqlSessionFactory.openSession();
            // Mapper Proxy 객체 반환 받음
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            System.out.println("반환받은 Proxy 객체 : " + employeeMapper);
            list = employeeMapper.findAll();
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
            sqlSession  = sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employee = employeeMapper.findById(employeeId);
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
            sqlSession  = sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            list = employeeMapper.findBySalaryRange(params);
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
            sqlSession  = sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            list = employeeMapper.findBySalaryRange2(min, max);
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
            sqlSession  = sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            list = employeeMapper.findByJoin();
        } finally {
            sqlSession.close();
        }
        return list;
    }

    // 사원 급여 정보 수정
    public void updateSalary(int employeeId, int salary){
        SqlSession sqlSession = null;
        try {
            sqlSession  = sqlSessionFactory.openSession(false);
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

//            Employee employee = new Employee();
//            employee.setId(employeeId);
//            employee.setSalary(salary);
//            employeeMapper.update(employee);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    // 사원 정보 동적 수정
    public void updateEmployee(Employee employee){
        SqlSession sqlSession = null;
        try {
            sqlSession  = sqlSessionFactory.openSession(false);
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            employeeMapper.dynamicUpdate(employee);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    // 검색
    public List<Employee> searchEmployee(String type, String value){
        SqlSession sqlSession = null;
        try {
            sqlSession  = sqlSessionFactory.openSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            if(type.equalsIgnoreCase("name")) value = "%" + value + "%";

            return  employeeMapper.search(type, value);
        } finally {
            sqlSession.commit();
        }
    }


    public static void main(String[] args) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
//        List<Employee> list = employeeService.getEmployees();
//        System.out.println(list);
//        Employee employee = employeeService.getEmployee(100);
//        System.out.println(employee);
//        Map<String, Integer> params = new HashMap<>();
//        params.put("min", 2000);
//        params.put("max", 3000);
//        List<Employee> list = employeeService.getEmployeesBySaley2(2000, 3000);
//        System.out.println(list);
//        System.out.println(employeeService.getEmployeesByJoin());

//        employeeService.updateSalary(100, 500);
//        System.out.println("수정 완료...");

//        Employee employee = new Employee();
//        employee.setId(100);
//        employee.setSalary(10000);
//        employee.setFirstName("killer");
//            Employee employee = Employee
//                .builder()
//                .id(100).salary(500).firstName("xxx").build();
//        employeeService.updateEmployee(employee);
//        System.out.println("수정 완료");

//        List<Employee> list = employeeService.searchEmployee("id", "65656565");
//        List<Employee> list = employeeService.searchEmployee("name", "k");
//        System.out.println(list);

    }

}
