package opgave3_observer.exercise3;

public class TrafficDemo {

    public static void main(String[] args) {
        TrafficCenter traffic = new TrafficCenter();

        traffic.addObserver(new RoutePlanner());
        traffic.addObserver(new ETACalculator());
        traffic.addObserver(new DriverDisplay());
        traffic.addObserver(new PublicWebsite());

        traffic.setCongestion("E40", 30);
        traffic.addIncident("Boom!");
        traffic.notifyObservers();

        traffic.setRoadClosed("A12", true);
        traffic.setCongestion("Ring", 90);
        traffic.notifyObservers();
    }
}