package opgave3_observer.exercise1;

import java.util.ArrayList;

public class WeatherData implements Subject{
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println("registered observer " + o.getClass().getSimpleName());
    }

    public void removeObserver(Observer o) {
            observers.remove(o);
            System.out.println("Removed observer " + o.getClass().getSimpleName());
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        //...
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        Smartphone smartphone = new Smartphone();
        Tablet tablet = new Tablet();
        Thermostat thermostat = new Thermostat();

        weatherData.registerObserver(smartphone);
        weatherData.registerObserver(tablet);
        weatherData.registerObserver(thermostat);

        weatherData.setMeasurements(18, 5, 5);

        weatherData.removeObserver(tablet);

        weatherData.setMeasurements(15, 4, 5);

        weatherData.registerObserver(tablet);

        weatherData.setMeasurements(10, 3, 3);
    }
}
