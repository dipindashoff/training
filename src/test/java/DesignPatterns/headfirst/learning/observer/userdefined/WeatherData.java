package DesignPatterns.headfirst.learning.observer.userdefined;

import java.util.ArrayList;
import java.util.List;

public class WeatherData {

    private List<Observer> observerList;
    private float temp, pressure;
    private int humidity;

    public WeatherData() {
        observerList = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObserver() {
        observerList.forEach(o -> o.update(temp, humidity, pressure));
    }

    public void measurementsChanged(float temp, int humidity, float pressure) {
        notifyObserver();
    }

    public void setMeasurements(float temp, int humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged(temp, humidity, pressure);
    }

}
