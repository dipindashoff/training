package DesignPatterns.headfirst.learning.observer.javautil;

public class TestWeatherData {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentDisplay currentDisplay = new CurrentDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        weatherData.setMeasurements(25.5f, 47, 90f);
        weatherData.setMeasurements(15f, 50, 80f);
        weatherData.setMeasurements(27f, 70, 90f);
    }
}
