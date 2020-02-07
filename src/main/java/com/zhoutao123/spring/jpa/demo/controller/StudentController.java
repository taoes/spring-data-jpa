package com.zhoutao123.spring.jpa.demo.controller;

import com.zhoutao123.spring.jpa.demo.domain.Student;
import com.zhoutao123.spring.jpa.demo.repository.StudentRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/stu")
@RestController
public class StudentController {

  private final StudentRepository studentRepository;

  public StudentController(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @GetMapping
  public List<Student> list() {
    return studentRepository.findAll();
  }

  /** 删除不存在的资源会报错 */
  @DeleteMapping
  public void deleteById(@RequestParam Integer id) {
    boolean exists = studentRepository.existsById(id);
    if (!exists) {
      log.info("删除失败,数据不存在");
      return;
    }

    studentRepository.deleteById(id);
    log.info("数据删除完成");
  }

  @GetMapping("/new")
  public Student create(String name, int age) {
    Student s = new Student();
    s.setName(name);
    s.setAge(age);
    studentRepository.save(s);
    return s;
  }
}
