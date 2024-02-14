package ru.gb.phonebook.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TrackingAspects {

    /**
     * Метод выводит в терминал запись о начале и конце выполнения операции
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(ru.gb.phonebook.aspects.TrackUserAction)")
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
    @Around("@annotation(ru.gb.phonebook.aspects.TrackWithTimingUserAction)")
    public Object logExecutionWithTiming(ProceedingJoinPoint joinPoint) throws Throwable {
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
