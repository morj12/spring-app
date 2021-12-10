package sample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author morj12
 * A simple AOP example class.
 */

@Component
@Aspect
public class MyLoggingAspect {

    /**
     * Around type advice: makes a print before and after each method.
     *
     * @param point intercepted method
     * @return returning of the intercepted method
     * @throws Throwable
     */
    @Around("execution(* sample.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint point) throws Throwable {
        MethodSignature ms = (MethodSignature) point.getSignature();        // Get the signature name
        String methodName = ms.getName();
        System.out.println("Begin of " + methodName);                       // Print before execution
        Object res = point.proceed();                                       // Execute method
        System.out.println("End of " + methodName);                         // Print after execution
        return res;
    }


}

