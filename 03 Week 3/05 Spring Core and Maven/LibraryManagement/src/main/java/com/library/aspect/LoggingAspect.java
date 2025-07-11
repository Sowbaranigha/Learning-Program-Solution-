package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {
    @Around("execution(* com.library..*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        long t0 = System.nanoTime();
        try { return pjp.proceed(); }
        finally { System.out.printf("%s took %d µs%n",
                 pjp.getSignature(), (System.nanoTime() - t0)/1_000); }
    }
}
