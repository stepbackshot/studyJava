package test;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Harden
 * @title: AppConfig
 * @date 2021年02月23日 22:21
 *
 * https://wiki.jikexueyuan.com/project/spring/aop-with-spring-framenwork/aspectj-based-aop-with-spring.html
 * https://www.cnblogs.com/joy99/p/10941543.html
 * https://wiki.jikexueyuan.com/project/spring/aop-with-spring-framenwork/aspectj-based-aop-with-spring.html
 */
//@Configuration用于定义配置类，定义的配置类可以替换xml文件，一般和@Bean注解联合使用。
@Configuration
/**
 * https://www.cnblogs.com/jpfss/p/11171655.html
 * @ComponentScan主要就是定义扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中
 */
@ComponentScan(basePackageClasses = {IBuy.class, AfterReturn.class})
//启用AOP功能
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
