package DesignPatterns.headfirst.learning.observer.javautil;

import java.util.Observable;
public class WeatherData extends Observable {

    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData(){

    }

    public void measurementsChanged(float temp, int humidity, float pressure) {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temp, int humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged(temp, humidity, pressure);
    }

    public float getTemp() {
        return temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
