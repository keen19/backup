package keen.service.impl;

import keen.dao.AccountDao;
import keen.dao.impl.AccountDaoImpl;

import keen.service.AccountService;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author keen1
 */

/**
 *  用于创建对象的
 *      他们的作用就和XML配置文件中编写一个<bean>标签实现的功能是一样的
 *      Component:
 *          作用:用于把当前类对象存入spring容器中
 *          属性:
 *              value: 用于指定bean的id,默认值是当前类名的首字母小写
 *      作用和Component一样,是spring用来实现三层架构使用的:
 *      Controller: 一般用在表现层
 *      Service: 业务层
 *      Repository: 持久层
 *
 *  用于注入数据的
 *      他们的作用就和XML配置文件中<bean>标签写一个<property标签></property标签>功能是一样的
 *      Autowired:
 *          作用:自动按照类型注入,只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配,就可以注入
 *              如果ioc容器中没有任何bean的类型和要注入的变量类型匹配.则报错
 *              如果有多个类型匹配时,
 *          出现位置: 变量上,方法上
 *          细节: 在使用注解注入时,无需创建set方法
 *      Qualifier:
 *          作用:在按照勒种注入的基础上再按照名称注入,给类成员注入时不能单独使用,给方法参数注入时可以单独使用
 *          属性:
 *              value:用于指定bean的id
 *      Resource:
 *          作用:直接按照bean的id注入.可以单独使用
 *          属性:
 *              name:指定bean的id
 *          以上三个都是注入其他bean类型的数据,基本类型和string类型无法使用
 *          集合类型的注入只能通过XML配置文件实现
 *
 *      Value
 *          作用:注入基本类型和string类型的数据
 *          属性:
 *              value:指定数据的值,可以使用spring中SpEL(spring的el表达式)
 *                  SpEL的写法: ${表达式}
 *  用于改变作用范围的
 *      他们的作用就和XML配置文件中<scope>标签一样
 *      Scope
 *          作用:指定bean的作用范围
 *          属性:
 *              value:范围的取值,常用取值:singleton,prototype
 *  生命周期相关 了解
 *  他们的作用就和XML配置文件中<bean>标签中init-method 和destroy-method一样
 *  PreDestroy
 *      作用:指定销毁方法
 *  PostConstruct
 *      作用:指定初始化方法
 */

@Component(value = "accountService")
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao;

    @Override
    public void saveAccount() {
        System.out.println("对象创建了");
    }

    public void init(){
        System.out.println("对象出生了");
    }
    public void destroy(){
        System.out.println("对象销毁");
    }
}
