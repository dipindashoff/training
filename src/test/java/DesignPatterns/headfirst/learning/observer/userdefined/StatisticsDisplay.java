package DesignPatterns.headfirst.learning.observer.userdefined;

public class StatisticsDisplay implements Observer, Display {
    private WeatherData weatherData;
    private float temp;

    public StatisticsDisplay(WeatherData weatherData){
        this.weatherData = weatherData;
        this.weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, int humidity, float pressure) {
        this.temp = temp;
        display();
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min: " + temp + "/" + temp+1 + "/" + temp);
    }

}
