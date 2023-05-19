package com.example.weatherforecast.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MainWeather {

    private double temp;

    private double temp_min;

    private double temp_max;

}
