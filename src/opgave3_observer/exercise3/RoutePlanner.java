package opgave3_observer.exercise3;

class RoutePlanner implements TrafficObserver {
    @Override
    public void update(TrafficSubject subject) {
        TrafficCenter t = (TrafficCenter) subject;
        System.out.println("[RoutePlanner] Checking route with congestion: " + t.getCongestion());
    }
}