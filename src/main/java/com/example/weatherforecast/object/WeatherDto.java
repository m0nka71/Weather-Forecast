package com.example.weatherforecast.object;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto {

    private double temperature;

    private double minTemperature;

    private double maxTemperature;

    private String city;
}
