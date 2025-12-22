package opgave3_observer.exercise3;

import java.util.Map;

public class ETACalculator implements TrafficObserver {
    private Map<String, Integer> congestionInfo;


    @Override
    public void update(TrafficSubject subject) {
        TrafficCenter t = (TrafficCenter) subject;
        congestionInfo = t.getCongestion();

        System.out.println("[ETACalculator] Recalculating ETA");
    }
}