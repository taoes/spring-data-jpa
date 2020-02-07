# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)


# 项目说明
> 这里继承了一些Spring Data JPA 框架的一些使用案例，方便一些开发同学快速的接入此框架，进行开发工作
> 为了保证其他业务需求不干扰JPA的代码演示，这里仅仅实现了最基本的代码，并未完全按照MVC的三层模式开发


# 使用说明
+ 修改 application.yml 的文件配置，修改数据的连接信息
+ 启动 SpringBoot 应用，在数据库连接信息正确的情况下，会自动创建数据库
+ 你也可以执行 test 目录下的的单元测试代码

# 说明
使用JPA开发配合DDD(Domain-Drive Design) 食用，效果更佳  [https://zhuanlan.zhihu.com/p/88528096](https://zhuanlan.zhihu.com/p/88528096)


# 参考资料
- Spring Data JPA  [https://spring.io/projects/spring-data-jpa](https://spring.io/projects/spring-data-jpa)
- Logic Delete  [https://www.jianshu.com/p/fe7b079dd485](https://www.jianshu.com/p/fe7b079dd485)
- Default Entity Param [https://blog.csdn.net/qq_35272054/article/details/90691896](https://blog.csdn.net/qq_35272054/article/details/90691896)



