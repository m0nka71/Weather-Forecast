package com.example.weatherforecast.error;

public class WeatherDataNotAvailableException extends RuntimeException {

    public WeatherDataNotAvailableException() {
        super("Nie udało się pobrać pogody dla wybranego miasta");
    }
}
