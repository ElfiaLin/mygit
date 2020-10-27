package com.jxd.emp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.emp.mapper.IBookMapper;
import com.jxd.emp.model.Book;
import com.jxd.emp.model.Emp;
import com.jxd.emp.service.IBookService;
import com.jxd.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;

/**
 * @ClassName IEmpController
 * @Description TODO
 * @Author linyafei
 * @Date 2020/10/22
 * @Version 1.0
 */
@Controller
public class EmpController {

    @Value("${name}")
    public String name;

    @Value("${student.sname}")
    private String sname;

    @Value("${persons[0].pname}")
    private String pname;

    @Autowired
    private IEmpService empService;

    @Autowired
    private IBookMapper bookMapper;

    @Autowired
    private IBookService bookService;

    @RequestMapping("hello")
    @ResponseBody
    public String hello() {
        System.out.println(name);
        System.out.println(sname);
        System.out.println(pname);
        return "Hello SpringBoot!!!!热部署测试";
    }

    @RequestMapping("test")
    @ResponseBody
    public String test() {
        return "测试测试";
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Emp> getAll() {
        return empService.getAll();
    }

    @RequestMapping("/getBook")
    @ResponseBody
    public List<Book> getBook() {
        /*return bookMapper.selectList(null);*/
        return bookService.list();
        //创建构造器对象
        /* Wrapper<Book> wrapper = new QueryWrapper<>();*/
        //  Wrapper<Book> wrapper = new Abstrac
    }

    @RequestMapping("/helloBtl")
    public String helloBtl(Model model){
        model.addAttribute("msg","Hello Btl!!!");
        return "hello.btl";
    }

    @RequestMapping("/helloBtl02")
    public String helloBtl02(Model model){
        model.addAttribute("msg","HTML模板文件");
        return "hello02.html";
    }
    @RequestMapping("/welcome")
    public String welcome(Model model){
        model.addAttribute("msg","改变了模板位置");
        List<Book> list = bookService.list();
        model.addAttribute("list",list);
        return "welcome.html";
    }
    @RequestMapping("/login/{uname}/{pwd}")
    @ResponseBody
    public String login(@PathVariable("uname") String uname,@PathVariable("pwd") String pwd){
        if ("admin".equals(uname) && "123".equals(pwd)){
            return "success";
        }else{
            return "error";
        }
    }
}
