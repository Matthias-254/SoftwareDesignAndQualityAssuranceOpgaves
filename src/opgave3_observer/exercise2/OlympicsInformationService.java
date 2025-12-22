package opgave3_observer.exercise2;

import java.util.ArrayList;
import java.util.List;

public class OlympicsInformationService implements Subject{
    private String schedulingData;
    private String participantprofiles;
    private String results;
    private List<Observer> observers;

    public OlympicsInformationService() {
        observers = new ArrayList<Observer>();
        schedulingData = "schedulingData";
        participantprofiles = "participantprofiles";
        results = "results";
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println("registered observer " + o.getClass().getSimpleName());

    }

    public void notifyObservers() {
        for (Observer observer: observers) {
            observer.update();
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
        System.out.println("Removed observer " + o.getClass().getSimpleName());

    }
    public String getSchedulingData() {
        return schedulingData;
    }
    public void setSchedulingData(String schedulingData) {

        this.schedulingData = schedulingData;
        notifyObservers();
    }
    public String getParticipantprofiles() {
        return participantprofiles;
    }
    public void setParticipantprofiles(String participantprofiles) {

        this.participantprofiles = participantprofiles;
        notifyObservers();
    }
    public String getResults() {
        return results;
    }
    public void setResults(String results) {

        this.results = results;
        notifyObservers();
    }

    public static void main(String[] args) {
        OlympicsInformationService informationService = new OlympicsInformationService();

        AthleteIntranet athleteIntranet = new AthleteIntranet(informationService);
        EventWebsite eventWebsite = new EventWebsite(informationService);
        JudgesIntranet judgesIntranet = new JudgesIntranet(informationService);
        PressIntranet pressIntranet = new PressIntranet(informationService);
        System.out.println("---");
        informationService.setParticipantprofiles("new info");
        System.out.println("---");
        informationService.setResults("new info");
        System.out.println("---");
        informationService.setSchedulingData("new info");

    }
}