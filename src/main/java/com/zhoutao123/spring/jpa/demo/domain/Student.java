package com.zhoutao123.spring.jpa.demo.domain;

import java.time.Instant;
import javax.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

/**
 * 实现逻辑删除
 *
 * <pre>
 *    @SQLDelete(sql = "UPDATE student SET delete_time = CURRENT_TIMESTAMP WHERE ID = ?")
 *    @Where(clause = "delete_time IS NULL")
 * </pre>
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "student")
@SQLDelete(sql = "UPDATE student SET delete_time = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "delete_time IS NULL")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private int age;

  private boolean adult;

  // 默认当前时间
  @CreationTimestamp private Instant createTime;

  // 默认更新的时间
  @UpdateTimestamp private Instant updateTime;

  private Instant deleteTime;

  public void resetId() {
    this.id = null;
  }
}
