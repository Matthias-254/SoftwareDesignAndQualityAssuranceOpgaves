package opgave3_observer.exercise2;

public class PressIntranet implements Observer{
    private OlympicsInformationService informationService;
    private String data;

    public PressIntranet(OlympicsInformationService informationService) {
        this.informationService = informationService;
        informationService.registerObserver(this);
    }

    @Override
    public void update() {
        if (!informationService.getResults().equals(data))
        {
            data = informationService.getResults();
            System.out.println(this.getClass().getSimpleName() + " " + data);

        }

    }
}