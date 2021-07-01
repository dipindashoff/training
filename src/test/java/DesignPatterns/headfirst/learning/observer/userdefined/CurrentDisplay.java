package DesignPatterns.headfirst.learning.observer.userdefined;

public class CurrentDisplay implements Observer, Display{

    private WeatherData weatherData;
    private float temp, pressure;
    private int humidity;

    public CurrentDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, int humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;

        display();
    }

    @Override
    public void display() {
        System.out.println("temperature: " + temp + "C, humidity: " + humidity + "%");
    }

}
