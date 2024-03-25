package org.simon.laboratory_bookingpro.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Aspect
@Component
public class LoggingAspect {

    //Logfile path
    private static final String LOG_FILE_PATH = "C:\\Users\\simon\\IdeaProjects\\Lab_booking_capstone_proj\\src\\main\\resources\\logfile.log";

    @Before("execution(* org.simon.laboratory_bookingpro.service.*.*(..)) && @annotation(transactional)")
    public void logTransactionStart(Transactional transactional) {
        log("Transaction started for method: " + transactional.value());
    }

    @AfterReturning(pointcut = "execution(* org.simon.laboratory_bookingpro.service.*.*(..)) && @annotation(transactional)", returning = "result")
    public void logTransactionSuccess(Transactional transactional, Object result) {
        log("Transaction successfully completed for method: " + transactional.value());
    }

    @AfterThrowing(pointcut = "execution(* org.simon.laboratory_bookingpro.service.*.*(..)) && @annotation(transactional)", throwing = "exception")
    public void logTransactionFailure(Transactional transactional, Throwable exception) {
        log("Transaction failed for method: " + transactional.value() + ". Error: " + exception.getMessage());
    }

    @Before("execution(* org.simon.laboratory_bookingpro.controller.*.*(..))")
    public void logRequest() {
        log("Request received at: " + LocalDateTime.now());
    }

    @AfterReturning(pointcut = "execution(* org.simon.laboratory_bookingpro.controller.*.*(..))", returning = "result")
    public void logResponse(Object result) {
        log("Response sent: " + result);
    }

    private void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE_PATH, true)) {
            writer.write(LocalDateTime.now() + " - " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
