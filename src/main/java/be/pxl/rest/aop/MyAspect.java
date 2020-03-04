package be.pxl.rest.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Around("execution(* *.sayHello(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("Join point reached...");
        Object returnValue = pjp.proceed();
        System.out.println("Leaving...");
        return returnValue;
    }
}
