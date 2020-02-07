package com.zhoutao123.spring.jpa.demo.repository;

import com.zhoutao123.spring.jpa.demo.domain.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {

  void deleteById(Integer id);

  Optional<Student> findByName(String name);

  @Modifying
  @Transactional
  @Query("DELETE FROM Student WHERE name = ?1")
  int deleteByName(String name);
}
