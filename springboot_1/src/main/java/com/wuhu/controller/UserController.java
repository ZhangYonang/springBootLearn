package com.wuhu.controller;

import com.wuhu.dao.EmployeeDao;
import com.wuhu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class UserController {
    @Autowired
    EmployeeDao employeeDao;
    @RequestMapping("/index")
    public String list(Model model){
        Collection<Employee> allUser = employeeDao.getAllUser();
        model.addAttribute("allUser",allUser);
        return "index";
    }
    // 添加员工
    @PostMapping("/adduser")
    public String addUser(Employee employee){
        System.out.println(employee);
        employeeDao.add(employee);
        return "redirect:/index";
    }
    // 修改员工页面
    @GetMapping("/update{id}")
    public String toUpDateUser(@PathVariable("id") Integer id,Model model){
        Employee update = employeeDao.getEmployeeById(id);
        model.addAttribute("update",update);
        return "/update";
    }

    // 修改员工
    @RequestMapping("/updateemp")
    public String upDateUser(Employee employee){
        return "redirect:/index";
    }

    // 删除员工
    @GetMapping("/delete{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/index";
    }
}

