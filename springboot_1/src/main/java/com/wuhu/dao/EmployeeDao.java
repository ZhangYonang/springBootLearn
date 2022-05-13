package com.wuhu.dao;

import com.wuhu.pojo.Department;
import com.wuhu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = new HashMap<>();;
    @Autowired
    private  DepartmentDao departmentDao;
    static {
        employees.put(1,new Employee(1,"q","123131313",1,new Department(101,"w")));
        employees.put(2,new Employee(2,"i","123131313",1,new Department(102,"u")));
        employees.put(3,new Employee(3,"f","123131313",1,new Department(103,"h")));
        employees.put(4,new Employee(4,"e","123131313",1,new Department(104,"u")));
        employees.put(5,new Employee(5,"i","123131313",1,new Department(105,"wuhu")));
    }
    // 主键自增
    private static Integer initId = 106;
    // 添加员工
    public void add(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    // 查询全部员工信息
    public Collection<Employee> getAllUser(){
        return employees.values();
    }
    // 通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    // 删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
