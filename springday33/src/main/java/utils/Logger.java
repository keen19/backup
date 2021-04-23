package utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Component("logger")
@Aspect//表示当前类是一个切面
public class Logger {
    @Pointcut("execution(* service.impl.*.*(..))")
    public void pt1(){

    }
    /**
     * 用于打印日志:计划让其在切入点方法执行前执行(切入点方法就是业务层方法)
     */
    public void printLog() {
        System.out.println("Logger的printLog方法开始记录日志、....");
    }

    /**
     * 前置通知
     */
    @Before("pt1()")
    public void beforePrintLog() {
        System.out.println("Logger的beforePrintLog方法开始记录日志、....");

    }

    /**
     * 后置通知
     */
    @AfterReturning("pt1()")
    public void afterReturningPrintLog() {
        System.out.println("Logger的afterReturningPrintLog方法开始记录日志、....");

    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void afterThrowingPrintLog() {
        System.out.println("Logger的afterThrowingPrintLog方法开始记录日志、....");

    }

    /**
     * 最终通知
     */
    @After("pt1()")
    public void afterPrintLog() {
        System.out.println("Logger的afterPrintLog方法开始记录日志、....");

    }

    /**
     * 环绕通知
     * 当我们配置了环绕通知之后,切入点方法没有执行,而通知方法执行了
     * 分析:
     *      通过对比动态代理中的环绕通知代码,发现动态代理的环绕通知有明确的调用,而我们的代码中没有
     * 解决:
     *      spring框架为我们提供了一个接口:ProceedingJoinPoint. 该接口的proceed()方法相当于在切入点方法的调用
     * @return
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            //得到方法执行所需的参数
            Object[] args=pjp.getArgs();

            System.out.println("Logger的aroundPrintLog方法开始记录日志、....前置");

            //明确调用业务层方法(切入点方法)
            rtValue=pjp.proceed(args);
            System.out.println("Logger的aroundPrintLog方法开始记录日志、....后置");

            return rtValue;
        }catch (Throwable t){
            System.out.println("Logger的aroundPrintLog方法开始记录日志、....异常");

            throw new RuntimeException(t);
        }finally {
            System.out.println("Logger的aroundPrintLog方法开始记录日志、....最终");

        }

    }
}
