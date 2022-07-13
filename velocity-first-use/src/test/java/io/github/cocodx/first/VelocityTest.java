package io.github.cocodx.first;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
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
        velocityContext.put("name","刚子哥");

        Template template = Velocity.getTemplate("vms/01-quickstart.vm", "utf-8");

        FileWriter fileWriter = new FileWriter("D:\\code\\IDEA_workspace\\velocity-parent\\velocity-first-use\\src\\main\\resources\\html\\01-quickstart.html");

        template.merge(velocityContext,fileWriter);

        fileWriter.close();
    }
}
