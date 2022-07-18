package io.github.cocodx.first;

import io.github.cocodx.first.entity.User;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

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

        FileWriter fileWriter = new FileWriter("D:\\code\\IDEA_workspace\\velocity-parent\\velocity-first-use\\src\\main\\resources\\html\\05-instructions-set.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }

}
