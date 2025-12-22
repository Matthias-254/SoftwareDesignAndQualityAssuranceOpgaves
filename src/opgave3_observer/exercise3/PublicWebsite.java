package opgave3_observer.exercise3;

public class PublicWebsite implements TrafficObserver {
    @Override
    public void update(TrafficSubject subject) {
        TrafficCenter t = (TrafficCenter) subject;
        System.out.println("[PublicWebsite] Closed roads: " + t.getClosedRoads());
    }
}