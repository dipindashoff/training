package DesignPatterns.headfirst.learning.observer.javautil;

import java.util.Observable;
import java.util.Observer;

public class CurrentDisplay implements Observer, Display {

    private WeatherData weatherData;
    private float temp, pressure;
    private float humidity;

    public CurrentDisplay(Observable o) {
        o.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            this.weatherData = (WeatherData) o;
            this.temp = weatherData.getTemp();
            this.humidity = weatherData.getHumidity();
            this.pressure = weatherData.getPressure();
        }
        display();
    }

    @Override
    public void display() {
        System.out.println("temperature: " + temp + "C, humidity: " + humidity + "%");
    }
}