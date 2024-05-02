package com.ezen.mybatis.domain.employee.mapper;

import com.ezen.mybatis.domain.employee.dto.Employee;
import java.util.List;

// JDBC 구현 시 Dao 인터페이스에 해당
public interface EmployeeMapper {
    public List<Employee> findAll();
    public Employee findById(int employeeId);
    public int findBySalary(int employeeId);
}
