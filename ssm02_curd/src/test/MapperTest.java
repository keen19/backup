

import keen.bean.Department;
import keen.bean.Employee;
import keen.dao.DepartmentMapper;
import keen.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层
 *
 * 导入spring-test模块
 * ContextConfiguration指定spring的配置文件的位置
 * 直接autowired要使用的组件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    /**
     * 测试DepartmentMapper
     */
    @Test
    public void testCRUD(){
//        //1.创建SpringIOC容器
//        ApplicationContext ioc=new ClassPathXmlApplicationContext("applicationContext.xml");
//        //2.获取mapper
//        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
//        //3.执行方法
//        bean.

        System.out.println(departmentMapper);

//        //1.插入几个部门
//        departmentMapper.insertSelective(new Department(null,"测试部"));
//        departmentMapper.insertSelective(new Department(null,"开发部"));
        //2.插入几个员工
        employeeMapper.insertSelective(new Employee(null,"Jerry","男","1231@qq.com",1));

        //3.批量插入,使用sqlSession
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5)+""+i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));
        }
        System.out.println("批量完成");

    }
}
