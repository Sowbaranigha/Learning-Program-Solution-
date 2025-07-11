package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component               // picked up by component‑scan
public class LoggingAspect {

    // ---------- before advice ----------
    @Before("execution(* com.library..*(..))")
    public void logBefore(JoinPoint jp) {
        System.out.println("▶ " + jp.getSignature() + " – started");
    }

    // ---------- after advice ----------
    @After("execution(* com.library..*(..))")
    public void logAfter(JoinPoint jp) {
        System.out.println("◀ " + jp.getSignature() + " – finished");
    }
}
