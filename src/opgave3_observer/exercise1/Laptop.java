package opgave3_observer.exercise1;

public class Laptop implements Observer{
    public float temperature;
    public float humidity;
    public float pressure;

    public Laptop() {

    }

    public void update(float t, float h, float p) {
        temperature = t;
        humidity = h;
        pressure =p;
        display();
    }

    public void display() {
        System.out.println(this.getClass().getSimpleName() + "=> temperature: " + temperature + ", humidity: " + humidity + " ,pressure:" + pressure);
    }
}
