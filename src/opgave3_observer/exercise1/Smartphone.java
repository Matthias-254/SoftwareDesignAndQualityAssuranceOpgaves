package opgave3_observer.exercise1;

public class Smartphone implements Observer{
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println(this.getClass().getSimpleName() + " => Temperature: " + temperature + "°C, " + "Humidity: " + humidity + "%, " + "Pressure: " + pressure + "hPa");
    }
}
