package org.zerock.springex.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Arrays;

@ControllerAdvice
public class CommonExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(NumberFormatException.class)
    public String exceptNumber(NumberFormatException numberFormatException){
        return "NUMBER FORMAT EXCEPTION";
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String exceptCommon(Exception exception){
        StringBuffer buffer = new StringBuffer("<ul>");

        buffer.append("<li>" + exception.getMessage()+"</li>");

        Arrays.stream(exception.getStackTrace()).forEach(stackTraceElement -> {
            buffer.append("<li>"+stackTraceElement+"</li>");
        });
        buffer.append("</ul>");

        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound() {
        return "custom404";
    }
}
