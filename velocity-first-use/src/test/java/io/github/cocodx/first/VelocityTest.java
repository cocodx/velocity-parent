package io.github.cocodx.first;

import io.github.cocodx.first.entity.User;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author amazfit
 * @date 2022-07-14 上午1:02
 **/
public class VelocityTest {

    /**
     * 1. 设置velocity的资源加载器
     * 2. 初始化velocity引擎
     * 3. 创建velocity容器
     * 4. 加载velocity模板文件
     * 5. 合并数据到模板
     * 6. 释放资源
     */
    @Test
    public void test() throws IOException {
        //1. 设置velocity的资源加载器
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(properties);

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("name1","刚子哥");

        Template template = Velocity.getTemplate("vms/02-cite-variable.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("D:\\code\\IDEA_workspace\\velocity-parent\\velocity-first-use\\src\\main\\resources\\html\\03-quickstart.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }

    @Test
    public void test2() throws IOException {
        //1. 设置velocity的资源加载器
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(properties);

        VelocityContext velocityContext = new VelocityContext();
        User user = new User();
        user.setUserName("zhangsan");
        user.setPassword("1q2w3e");
        user.setEmail("860721890@qq.com");

        velocityContext.put("user",user);

        Template template = Velocity.getTemplate("vms/03-cite-field.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("D:\\code\\IDEA_workspace\\velocity-parent\\velocity-first-use\\src\\main\\resources\\html\\03-cite-field.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }


    @Test
    public void test3() throws IOException {
        //1. 设置velocity的资源加载器
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(properties);

        VelocityContext velocityContext = new VelocityContext();

        velocityContext.put("str","hello word velocity");
        velocityContext.put("now",new Date());

        Template template = Velocity.getTemplate("vms/04-cite-method.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("D:\\code\\IDEA_workspace\\velocity-parent\\velocity-first-use\\src\\main\\resources\\html\\04-cite-method.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }


    @Test
    public void test4() throws IOException {
        //1. 设置velocity的资源加载器
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(properties);

        VelocityContext velocityContext = new VelocityContext();

//        velocityContext.put("str","hello word velocity");
//        velocityContext.put("now",new Date());

        Template template = Velocity.getTemplate("vms/05-instructions-set.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("05-instructions-set.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }

    @Test
    public void test6() throws IOException {
        //1. 设置velocity的资源加载器
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(properties);

        VelocityContext velocityContext = new VelocityContext();

//        velocityContext.put("str","hello word velocity");
//        velocityContext.put("now",new Date());

        Template template = Velocity.getTemplate("vms/06-instructions-if.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("06-instructions-if.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }

    /**
     * foreach
     * @throws IOException
     */
    @Test
    public void test7() throws IOException {
        //1. 设置velocity的资源加载器
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(properties);

        VelocityContext velocityContext = new VelocityContext();

        //字符串数组
        String[] hobbies = new String[]{"eat","drink","play","happy"};
        velocityContext.put("hobbies",hobbies);

        //对象集合
        List<User> userList = new ArrayList<>();
        userList.add(new User("1","1","1"));
        userList.add(new User("2","2","2"));
        userList.add(new User("3","3","3"));
        userList.add(new User("4","4","4"));
        userList.add(new User("5","5","5"));
        userList.add(new User("6","6","6"));
        userList.add(new User("7","7","7"));
        velocityContext.put("userList",userList);

        //map集合
        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        velocityContext.put("map",map);

        Template template = Velocity.getTemplate("vms/07-instructions-foreach.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("07-instructions-foreach.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }

    /**
     * include指令
     * @throws IOException
     */
    @Test
    public void test8() throws IOException {
        //1. 设置velocity的资源加载器
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(properties);

        VelocityContext velocityContext = new VelocityContext();


        Template template = Velocity.getTemplate("vms/08-reference-include.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("08-reference-include.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }

    /**
     * parse指令
     * @throws IOException
     */
    @Test
    public void test9() throws IOException {
        //1. 设置velocity的资源加载器
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(properties);

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("name","郭嘉");
        Template template = Velocity.getTemplate("vms/09-reference-parse.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("09-reference-parse.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }

    /**
     * define 封装静态的html代码
     * @throws IOException
     */
    @Test
    public void test10() throws IOException {
        //1. 设置velocity的资源加载器
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(properties);

        VelocityContext velocityContext = new VelocityContext();
        //对象集合
        List<User> userList = new ArrayList<>();
        userList.add(new User("1","1","1"));
        userList.add(new User("2","2","2"));
        userList.add(new User("3","3","3"));
        userList.add(new User("4","4","4"));
        userList.add(new User("5","5","5"));
        userList.add(new User("6","6","6"));
        userList.add(new User("7","7","7"));
        velocityContext.put("userList",userList);
        Template template = Velocity.getTemplate("vms/10-reference-define.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("10-reference-define.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }

    /**
     * evaluate
     * @throws IOException
     */
    @Test
    public void test11() throws IOException {
        //1. 设置velocity的资源加载器
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(properties);

        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("code","#if($language.equals(\"java\"))\n" +
                "JAVA开发工程师\n" +
                "#elseif($language.equals(\"php\"))\n" +
                "PHP开发工程师\n" +
                "#else\n" +
                "开发工程师\n" +
                "#end");

        Template template = Velocity.getTemplate("vms/11-reference-evaluate.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("11-reference-evaluate.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }

    /**
     * 宏定义
     * @throws IOException
     */
    @Test
    public void test12() throws IOException {
        //1. 设置velocity的资源加载器
        Properties properties = new Properties();
        properties.put("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        Velocity.init(properties);

        VelocityContext velocityContext = new VelocityContext();
        //对象集合
        List<User> userList = new ArrayList<>();
        userList.add(new User("1","1","1"));
        userList.add(new User("2","2","2"));
        userList.add(new User("3","3","3"));
        userList.add(new User("4","4","4"));
        userList.add(new User("5","5","5"));
        userList.add(new User("6","6","6"));
        userList.add(new User("7","7","7"));
        velocityContext.put("list",userList);

        Template template = Velocity.getTemplate("vms/12-macro.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("12-macro.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }
}
