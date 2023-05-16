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
    String findWeather(Model model,String city) {
        WeatherDto weatherDto = weatherService.getWeatherByCity(city);
        model.addAttribute("weatherDto", weatherDto);
        model.addAttribute("city", city);
        return "index";
    }

//    @GetMapping("/city-weather")
//    String findWeather(Model model) {
//        model.addAttribute("city", city);
//        WeatherDto weatherDto = weatherService.getWeatherByCity(city);
//
//        model.addAttribute("weatherDto", weatherDto);
//        return "redirect:city-weather";
//    }

}
