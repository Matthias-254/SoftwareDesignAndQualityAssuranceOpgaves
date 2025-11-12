package observer.exercise1;

public class Tablet implements Observer{
    private float temperature;
    private float humidity;
    private float pressure;

    public Tablet() {

    }

    public void update(float t, float h, float p) {
        temperature = t;
        humidity = h;
        pressure = p;
        display();
    }

    public void display() {
        System.out.println(this.getClass().getSimpleName() + " => Temperature: " + temperature + "°C, " + "Humidity: " + humidity + "%, " +"Pressure: " + pressure +"hPa");
    }
}
