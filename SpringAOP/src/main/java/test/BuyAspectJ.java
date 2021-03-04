package test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Harden
 * @title: BuyAspectJ
 * @date 2021年02月23日 22:35
 */

/**
 * @Aspect 表示这个是切面
 * @Component 表明当前类将是一个被装配的spring bean
 *
 */
@Aspect
@Component
public class BuyAspectJ {
    /**
     * 切入点前执行
     */
    @Before("execution(* test.IBuy.buy(..))|| bean(afterReturn)")
    public void before() {
        System.out.println( "自己选自己的东西！！！！！！！！！！！！！" );
    }

    /**
     * 切入点的方法执行完后执行
     */
    @After("execution(* test.IBuy.buy(..)) || bean(afterReturn)")
    public void after() {
        System.out.println( "买好了回家呀。。。。。" );
    }

    /**
     * After方法先于AfterReturning之前执行
     */
    @AfterReturning("bean(afterReturn)")
    public void afterReturning() {
        System.out.println( "finished..." );
        System.out.println( "==========================================================================================" );
    }

    /**
     * 出现异常后执行
     */
    @AfterThrowing("bean(afterReturn)")
    public void afterThrowing() {
        System.out.println( "afterThrowing..." );
    }

    /**
     * 切入点前后执行
     *
     * 1.如果用around的同时用了afterthrowing，抛异常的话不会执行afterthrowing.
     *
     * 2.around先于before执行，先于after执行
     *          Around aaa ...
     *          自己选自己的东西！！！！！！！！！！！！！
     *          Around bbb ...
     *          买好了回家呀。。。。。
     *          finished...
     *          ==========================================================================================
     *
     * @param pj
     */
    @Around("execution(* test.IBuy.buy(..)) || bean(afterReturn)")
    public void around(ProceedingJoinPoint pj) {
        try {
            System.out.println( "Around aaa ..." );
//            Object[] obj = pj.getArgs();
//            obj[0] = 0;
//            if (obj.length > 0) obj[0] = 0;
            pj.proceed();
//            pj.proceed( obj );
            System.out.println( "Around bbb ..." );
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
