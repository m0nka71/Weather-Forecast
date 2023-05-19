package com.example.weatherforecast;

import com.example.weatherforecast.object.Weather;
import com.example.weatherforecast.object.WeatherDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class WeatherService {

    private static final String URL = "http://api.openweathermap.org/data/2.5/";

    private final String API_ID = "95f3bce1fce123d8e048df2598bb0df7";

    private final static RestTemplate restTemplate = new RestTemplate();

    public Optional<WeatherDto> getWeatherByCity(String city) {
        try {
            Weather weather = restTemplate.getForObject(URL + "weather?q={city}&appid={api_id}&units=metric&lang=pl",
                    Weather.class, city, API_ID);

            WeatherDto build = WeatherDto
                    .builder()
                    .temperature(weather.getMain().getTemp())
                    .minTemperature(weather.getMain().getTemp_min())
                    .maxTemperature(weather.getMain().getTemp_max())
                    .city(city)
                    .build();
            return Optional.of(build);
        } catch (Exception e) {
            Optional.empty();
        }
        return Optional.empty();
    }
}
