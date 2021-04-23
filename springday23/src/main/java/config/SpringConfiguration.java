package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 该类是一个配置类,它的作用和bean.xml一样
 * spring中的新注解
 * Configuration
 *      作用:指定当前类是一个配置类
 *      细节: 当配置类作为AnnotationConfigApplicationContext对象的参数时,可以不写注解
 * ComponentScan
 *      作用:用于通过注解指定spring在创建容器时要扫描的包
 *      属性:
 *          value:它和basePackages作用是一样的,都是用于指定创建容器时要扫描的包
 *          我们使用此注解就等于在xml配置中的
 *              <context:component-scan base-package="keen"/>
 *  Bean
 *      作用:用于把当前方法的返回值作为bean对象存入spring的ioc容器中
 *      属性:
 *          name:指定bean的id,不写时,默认为当前方法的名称
 *      细节:
 *          当我们注解配置方法时,如果方法有参数,spring框架会去容器中查找有没有可用的对象,
 *          查找的方式和Autowired一样,
 *
 *  Import:
 *      作用:导入其他配置类
 *
 *  PropertySource
 *      作用:用于指定properties文件的位置
 *      属性:
 *          value: 指定文件的名称和路径
 *              关键字:classpath:表示类路径下
 */
@Configuration
@ComponentScan(basePackages = "keen")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {

}
