package az.code.course26a.logging;


import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Base64;
import java.util.Enumeration;
import java.util.UUID;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* az.code.course26a.controller.*.*(..))")
    public void logBeforeApiCall(JoinPoint joinPoint) {
        String logId = UUID.randomUUID().toString();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info(logId + " Request URL: " + request.getRequestURL());
        log.info(logId + " HTTP Method: " + request.getMethod());

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            log.info(logId + " " + headerName + " " + headerValue);

        }

        MDC.put("username", new String(Base64.getDecoder().decode(request.getHeader("authorization").substring(6))));
        MDC.put("log_id", logId);


        log.info("IP Address: " + request.getRemoteAddr());
        log.info("Class Method: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("Arguments: " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* az.code.course26a.controller.*.*(..))", returning = "result")
    public void logAfterApiCall(Object result) {
        log.info( MDC.get("log_id")+ " Response: " + result);
    }


    @AfterThrowing(pointcut = "allRepositoryMethods() || allServiceMethods()", throwing = "throwable")
    public void logAfterApiCall(Throwable throwable) {
        log.error(throwable.getMessage());
    }


    @Pointcut("@within(org.springframework.stereotype.Service)")
    protected void allServiceMethods() {
        // This point cut is for all service layer methods
    }

    /**
     * Pointcut method for all repository layer methods.
     */
    @Pointcut("@within(org.springframework.stereotype.Repository)")
    protected void allRepositoryMethods() {
        // This point cut is for all repository layer methods
    }


}
