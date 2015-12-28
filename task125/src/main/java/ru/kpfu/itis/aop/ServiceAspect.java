package ru.kpfu.itis.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;

public class ServiceAspect {

    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Date start = new Date();
        System.out.println("start:" + start);
        Object result = joinPoint.proceed();
        Date end = new Date();
        System.out.println("end:" + end);
        System.out.println("duration in ms: " + (end.getTime() - start.getTime()));
        return result;
    }

    public Object catchExceptions(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            String exName = throwable.getMessage();
            String args = Arrays.toString(joinPoint.getArgs());
            Type type = ((MethodSignature) joinPoint.getSignature()).getReturnType();
            String mess = "Exception: " + exName + " catched for arguments " + args + "; return: " + type;
            System.out.println(mess);
        }
        return result;
    }
}
