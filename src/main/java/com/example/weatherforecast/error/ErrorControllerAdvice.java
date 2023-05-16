package com.example.weatherforecast.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(WeatherDataNotAvailableException.class)
    public String handleException() {
        return "nodata";
    }
}
