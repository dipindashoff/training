package DesignPatterns.headfirst.learning.observer.userdefined;

public class TestWeatherData {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentDisplay currentDisplay = new CurrentDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
        weatherData.setMeasurements(25.5f, 47, 90f);
        weatherData.setMeasurements(15f, 50, 80f);
        weatherData.setMeasurements(27f, 70, 90f);
    }
}
