package com.example.weatherforecast;

import com.example.weatherforecast.object.WeatherDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

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
        Optional<WeatherDto> weatherByCity = weatherService.getWeatherByCity(weatherDto.getCity());
        if (weatherByCity.isPresent()) {
            model.addAttribute("foundWeather", true);
            model.addAttribute("weatherDto", weatherByCity.get());
        } else {
            model.addAttribute("weatherNotFound", true);
        }
        return "index";
    }
}
