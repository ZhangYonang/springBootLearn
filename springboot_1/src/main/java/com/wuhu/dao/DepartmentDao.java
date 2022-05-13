package com.wuhu.dao;

import com.wuhu.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer,Department>();// 创建一个部门表
        departments.put(101,new Department(101,"w"));
        departments.put(102,new Department(102,"u"));
        departments.put(103,new Department(103,"h"));
        departments.put(104,new Department(104,"u"));
        departments.put(105,new Department(105,"wuhu"));
    }
    // 获取所有部门信息
    public Collection<Department> getDepartment (){
        return departments.values();
    }
    // 通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

}
