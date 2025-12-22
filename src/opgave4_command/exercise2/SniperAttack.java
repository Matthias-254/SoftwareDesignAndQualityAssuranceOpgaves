package opgave4_command.exercise2;

public class SniperAttack implements AttackCommand{
    private Sniper sniper;

    public SniperAttack(Sniper sniper) {
        super();
        this.sniper = sniper;
    }

    @Override
    public void fight() {
        sniper.aim();
        sniper.shoot();
    }

}