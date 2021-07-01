package DesignPatterns.headfirst.learning.observer.userdefined;

public class ForecastDisplay implements Observer, Display {
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, int humidity, float pressure) {
        display();
    }

    @Override
    public void display() {
        System.out.println("Forecast: Watch out for cooler rainy weather");
    }

}
