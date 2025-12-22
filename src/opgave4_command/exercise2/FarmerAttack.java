package opgave4_command.exercise2;

public class FarmerAttack implements AttackCommand {
    private Farmer farmer;

    public FarmerAttack(Farmer farmer) {
        super();
        this.farmer = farmer;
    }

    @Override
    public void fight() {
        if (!farmer.isDressed()) farmer.gettingDressed();
        farmer.takeStick();
        farmer.beatWithStick();
    }

}