package com.ezen.mybatis.domain.employee.mapper;

import com.ezen.mybatis.domain.employee.dto.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

// 애노테이션 기반 매퍼 인터페이스
public interface AnnotationEmployeeMapper {
    /** 사원 전체 목록 조회 */
    @Select(" SELECT employee_id  id," +
            "       first_name   firstName," +
            "       last_name    lastName," +
            "       email," +
            "       phone_number phoneNumber," +
            "       TO_CHAR(hire_date, 'YYYY-MM-DD') hireDate,"+
            "       salary" +
            " FROM   employees" +
            " ORDER BY hire_date ASC")
    public  List<Employee> findAll();


    @Results({
            @Result(property="id", column="employee_id"),
            @Result(property="firstName", column="first_name"),
            @Result(property="lastName", column="last_name"),
            @Result(property="email", column="email"),
            @Result(property="phoneNumber", column="phone_number"),
            @Result(property="hireDate", column="hireDate"),
            @Result(property="salary", column="salary")
    })

    @Select(" SELECT employee_id," +
            "       first_name," +
            "       last_name," +
            "       email," +
            "       phone_number," +
            "       TO_CHAR(hire_date, 'YYYY-MM-DD') hireDate,"+
            "       salary" +
            " FROM   employees" +
            "       WHERE  employee_id = #{id}" +
            " ORDER BY hire_date ASC")
    public Employee findById(int id) throws RuntimeException;

}
