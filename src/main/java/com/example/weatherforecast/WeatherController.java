package com.example.weatherforecast;

import com.example.weatherforecast.object.WeatherDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    String findWeather(Model model) {
        model.addAttribute("weatherDto", new WeatherDto());
        return "index";
    }

    @GetMapping("/city-weather")
    String findWeather(Model model, WeatherDto weatherDto) {
        WeatherDto weatherByCity = weatherService.getWeatherByCity(weatherDto.getCity());
        model.addAttribute("weatherDto", weatherByCity);
        return "index";
    }

}
