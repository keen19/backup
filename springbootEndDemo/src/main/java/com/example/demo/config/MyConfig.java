package com.example.demo.config;

import com.example.demo.bean.Pet;
import com.example.demo.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

//配置文件

/**
 *  1. 告诉springboot 这是一个配置类 = 配置文件
 *  2. 配置类也是组件
 *
 *  3. proxyBeanMethods :
 *  = true  使用一个容器里的实例(单例模式)
 *  = false 生成一个新的实例
 *
 *  4. @Import({User.class,Pet.class})
 *  给容器中创建这两个组件,默认组件名字就是全类名
 *
 *  5. @ImportResource("classpath:beans.xml")
 *  扫描配置文件,把配置文件的实例放进容器
 * @author keen1
 */
//@Import({User.class,Pet.class})
@Configuration(proxyBeanMethods = true)
//@ImportResource("classpath:beans.xml")
public class MyConfig {

    /**
     * 添加组件,方法名为组件id,返回类型就是组件中的实例
     * @return 返回一个User实例
     */
    @Bean("zhangsan")
    public User user01(){
        return new User("zhangsan",18);

    }

    @Bean
    public Pet tom(){
        return new Pet("tom");
    }
}
