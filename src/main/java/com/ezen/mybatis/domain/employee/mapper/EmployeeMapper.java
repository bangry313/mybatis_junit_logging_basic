package com.ezen.mybatis.domain.employee.mapper;

import com.ezen.mybatis.domain.employee.dto.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

// JDBC 구현 시 Dao 인터페이스에 해당
public interface EmployeeMapper {

    public void create(Employee employee);
    public void update(Employee employee);
    public List<Employee> findAll();
    public Employee findById(int employeeId);

    public int findBySalary(int employeeId);

    public List<Employee> findBySalaryRange(Map<String, Integer> params);

    public List<Employee> findBySalaryRange2(@Param("min") Integer min,  @Param("max") Integer max);

    public List<Map<String, Object>> findByJoin();
}