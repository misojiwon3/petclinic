package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(LogExecutionTime)") // LogExecutionTime 이라는 annotation 주변에 다음 코드를 삽입
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // joinPoint : 해당 annotation 이 붙어 있는 method

        StopWatch sw = new StopWatch();
        sw.start();

        Object proceed = joinPoint.proceed(); // method 실행

        sw.stop();

        logger.debug(sw.prettyPrint());
        System.out.println("123");

        return proceed;
    }
}
