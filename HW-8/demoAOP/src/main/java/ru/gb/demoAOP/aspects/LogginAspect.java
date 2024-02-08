package ru.gb.demoAOP.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Класс аспектов
 */
@Aspect
@Component
public class LogginAspect {

    /**
     * Метод выводит в терминал запись о начале и конце выполнения операции
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(ru.gb.demoAOP.aspects.LoggedExecution)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        System.out.println("Будет выполнен метод " + methodName +
                " с параметрами " + Arrays.asList(arguments) + ".");

        Object returnedByMethod = joinPoint.proceed(arguments);

        System.out.println("Был выполнен метод " + methodName + ".");

        return returnedByMethod;
    }

    /**
     * Метод выводит в терминал запись о начале, конце и времени выполнения операции
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(ru.gb.demoAOP.aspects.TimeLoggedExecution)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        System.out.println("Будет выполнен метод " + methodName +
                " с параметрами " + Arrays.asList(arguments) + ".");
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " - выполнено за " + executionTime + " мс.");
        return proceed;
    }
}
