package opgave3_observer.exercise3;

public class DriverDisplay implements TrafficObserver {
    @Override
    public void update(TrafficSubject subject) {
        TrafficCenter t = (TrafficCenter) subject;
        System.out.println("[DriverDisplay] Incidents: " + t.getIncidents());
    }
}