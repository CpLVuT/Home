# 一些教程
- 我会根据我接下来完成代码的顺序（先后再内）来讲解一些东西
- 并提出一些难以解决的问题解释
- 但是不要抄我代码 thx a lot
## 其一 springboot
   首先第一点，springboot不是一种崭新的语言
   springboot是一种架构框架，硬要类比的话就相当于一个学校有很多班级，班级有很多学生
   学生相当于细分的java的各种类以及实现的方法之类的，班级就是我们接下来要说的dao啊之类的
   那springboot就相当于这个学校。

   也就不先说什么具体springboot都能干嘛了。
   就简单说下配置吧
   
   springboot的好处在于不用手动去找各种依赖jar包

   因为他兼容了maven，所以我们只需要配置maven就可以了

   大家搜索完maven后会发现一般都停留在配置镜像这一步，然后该干嘛就不知道了。

-   那我们需要先打开pom.xml（如果你是和我一样用idea建立整个项目的话选择maven他应该是有显示的）
- 然后在xml的下面填写dependeny依赖，格式如下
~~~  <dependencies>
        <dependency>
            <groupId></groupId>
            <artifactId></artifactId>
            <version></version>
        </dependency>
    </dependencies>
~~~
这一步一定要上下一一对照，groupid和artfactid是什么在这里你也暂时不要深究

比如我们如果想要用springboot的框架就需要导入org.springframework.boot
~~~
        <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-orm</artifactId>
        <version>4.0.0.RELEASE</version>
        </dependency>
        <dependency>
~~~
我们就这么写在里面就可以了。
- 导入各种包后记得在当前文件夹mvn install
maven部分就完成了 从这里开始你就可以建立自己的springboot代码了

 课设应该需要的是mysql，springboot，更具体的包请自行查找。

- 这个网站可以生成一些你需要的dependency https://mvnrepository.com