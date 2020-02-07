package com.zhoutao123.spring.jpa.demo;

import com.zhoutao123.spring.jpa.demo.domain.Student;
import com.zhoutao123.spring.jpa.demo.repository.StudentRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.DEFAULT)
public class DemoApplicationTests {

  @Autowired StudentRepository studentRepository;

  private List<String> nameList;

  @Before
  public void init() {
    Student student = new Student();
    student.setAge(18);
    nameList = Arrays.asList("张三", "李四", "王二", "周六", "李五");
    nameList.stream()
        .map(student::setName)
        .forEach(
            s -> {
              s.resetId();
              studentRepository.save(s);
            });
    log.info("初始化测试数据环境完成");
  }

  @Test
  public void contextLoads() {
    List<Student> studentList = studentRepository.findAll();
    studentList.forEach(student -> log.info("{}", student));
    assert studentList.size() == nameList.size();
  }

  @Test
  public void testGetByName() {
    for (String name : nameList) {
      Optional<Student> student = studentRepository.findByName(name);
      assert student.isPresent();
      assert Objects.equals(student.get().getName(), name);
    }
    log.info("测试testGetByName通过");
  }

  @After
  public void testLogicDelete() {
    for (String name : nameList) {
      studentRepository.deleteByName(name);
      Optional<Student> student = studentRepository.findByName(name);
      assert !student.isPresent();
    }
    log.info("测试testLogicDelete通过");
  }
}
