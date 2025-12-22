package opgave3_observer.exercise3;

public interface TrafficSubject {
    void addObserver(TrafficObserver o);

    void removeObserver(TrafficObserver o);

    void notifyObservers();
}