package com.example.weatherforecast;

import com.example.weatherforecast.error.WeatherDataNotAvailableException;
import com.example.weatherforecast.object.Weather;
import com.example.weatherforecast.object.WeatherDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String URL = "http://api.openweathermap.org/data/2.5/forecast/";

    private final String API_ID = "{95f3bce1fce123d8e048df2598bb0df7}";

    private final static RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeatherByCity(String city) {
        Weather weather = restTemplate.getForObject(URL + "weather?q={city}&appid={api_id}&units=metric&lang=pl",
                Weather.class, city, API_ID);
        try {
            assert weather != null;
            return WeatherDto
                    .builder()
                    .temperature(weather.getTemp())
                    .minTemperature(weather.getTemp_min())
                    .maxTemperature(weather.getTemp_max())
                    .build();
        } catch (Exception e) {
            throw new WeatherDataNotAvailableException();
        }
    }
}
