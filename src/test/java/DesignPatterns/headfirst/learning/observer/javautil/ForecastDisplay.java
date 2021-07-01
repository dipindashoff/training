package DesignPatterns.headfirst.learning.observer.javautil;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, Display {
    private WeatherData weatherData;
    private float temp;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        this.weatherData.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            this.weatherData = (WeatherData) o;
            this.temp = weatherData.getTemp();
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("Forecast: Watch out for cooler rainy weather");
    }

}
