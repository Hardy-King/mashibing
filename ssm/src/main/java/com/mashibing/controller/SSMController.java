package com.mashibing.controller;

import com.mashibing.bean.Emp;
import com.mashibing.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SSMController {
    @Autowired
    private EmpDao empDao;

    @RequestMapping("/test")
    public String test(){
        System.out.println("test");
        Emp emp = empDao.selectEmpAndDeptByEmpno(7369);
        System.out.println(emp);
        return "success";

    }
    @RequestMapping("/test2")
    public String test2(Model model){
        System.out.println("test2");
        Emp emp = empDao.selectEmpAndDeptByEmpno(7369);
        model.addAttribute("emp",emp);
        System.out.println(emp);
        return "success";

    }
}
