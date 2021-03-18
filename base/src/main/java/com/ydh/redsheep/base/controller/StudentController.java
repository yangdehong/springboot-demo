package com.ydh.redsheep.base.controller;

import com.ydh.redsheep.base.mapper.StudentMapper;
import com.ydh.redsheep.base.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController //相当于配置 @Responsebody+@Controller
@RequestMapping("student")
public class StudentController {

    @Resource
    private StudentMapper studentMapper;

    @GetMapping("add")
    public String add(@RequestParam String name){
        Student student = new Student();
        student.setName(name);
        studentMapper.insert(student);
        return "sucess";
    }
    @GetMapping("update")
    public String update(@RequestParam Integer id,
                         @RequestParam String name){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        studentMapper.updateByPrimaryKey(student);
        return "sucess";
    }
    @GetMapping("get")
    public String get(){
        List<Student> students = studentMapper.selectAll();
        return students.toString();
    }
    @GetMapping("delete")
    public String delete(@RequestParam Integer id){
        studentMapper.deleteByPrimaryKey(id);
        return "sucess";
    }


}
