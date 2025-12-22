package opgave3_observer.exercise2;

public class JudgesIntranet implements Observer{
    private OlympicsInformationService informationService;
    private String data;

    public JudgesIntranet(OlympicsInformationService informationService) {
        this.informationService = informationService;
        informationService.registerObserver(this);
    }

    @Override
    public void update() {
        if (!informationService.getParticipantprofiles().equals(data))
        {
            data = informationService.getParticipantprofiles();
            System.out.println(this.getClass().getSimpleName() + " " + data);

        }
    }
}