package opgave3_observer.exercise3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrafficCenter implements TrafficSubject {
    private final List<TrafficObserver> observers = new ArrayList<>();

    private Map<String, Integer> congestion = new HashMap<>();
    private List<String> incidents = new ArrayList<>();
    private Set<String> closedRoads = new HashSet<>();

    @Override
    public void addObserver(TrafficObserver o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(TrafficObserver o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (TrafficObserver o : observers) {
            o.update(this); // pull model
        }
    }

    public void setCongestion(String road, int value) {
        congestion.put(road, value);
    }

    public void addIncident(String description) {
        incidents.add(description);
    }

    public void setRoadClosed(String road, boolean closed) {
        if (closed)
            closedRoads.add(road);
        else
            closedRoads.remove(road);
    }

    public Map<String, Integer> getCongestion() {
        return congestion;
    }

    public List<String> getIncidents() {
        return incidents;
    }

    public Set<String> getClosedRoads() {
        return closedRoads;
    }
}