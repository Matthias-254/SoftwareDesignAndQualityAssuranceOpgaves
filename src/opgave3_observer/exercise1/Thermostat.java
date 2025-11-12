package opgave3_observer.exercise1;

public class Thermostat implements Observer{
    private float tempature;
    private float humidity;
    private float pressure;

    public Thermostat() {

    }

    public void update(float t, float h, float p) {
        tempature = t;
        humidity = h;
        pressure =p;
        display();
    }

    public void display() {
        System.out.println(this.getClass().getSimpleName() + " => Tempature: " + tempature + "°C, " + "Humidity: " + humidity + "%, " + "Pressure: " + pressure + "hPa");
    }
}
