package test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Harden
 * @title: AppTest
 * @date 2021年02月23日 22:23
 */
public class AppTest {

    @Test
    public void test(){
        AnnotationConfigApplicationContext context = getAnnotationConfigApplicationContext();
        Boy boy = context.getBean( "boy",Boy.class );
        Girl girl = context.getBean( "girl", Girl.class);
        boy.buy();
        girl.buy();
    }

    private AnnotationConfigApplicationContext getAnnotationConfigApplicationContext() {
        return new AnnotationConfigApplicationContext( AppConfig.class );
    }

    @Test
    public void testAfterReturning(){
        AnnotationConfigApplicationContext context = getAnnotationConfigApplicationContext();
        AfterReturn afterReturn = context.getBean( "afterReturn",AfterReturn.class );
        afterReturn.execute();
    }

    @Test
    public void testAfterThrowing(){
        AnnotationConfigApplicationContext context = getAnnotationConfigApplicationContext();
        AfterReturn afterReturn = context.getBean( "afterReturn",AfterReturn.class );
        afterReturn.getValue(1);
        afterReturn.getValue(0);
    }
}
