package opgave3_observer.exercise2;

public class AthleteIntranet implements Observer{
    private OlympicsInformationService informationService;
    private String data;

    public AthleteIntranet(OlympicsInformationService informationService) {
        this.informationService = informationService;
        informationService.registerObserver(this);

    }

    @Override
    public void update() {
        if (!informationService.getSchedulingData().equals(data))
        {
            data = informationService.getSchedulingData();
            System.out.println(this.getClass().getSimpleName() + " " + data);

        }
    }

}