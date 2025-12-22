package opgave4_command.exercise2;

public class SoldierAttack implements AttackCommand {
    private Soldier soldier;

    public SoldierAttack(Soldier soldier) {
        super();
        this.soldier = soldier;
    }

    @Override
    public void fight() {
        soldier.takeRifle();
        soldier.shootRifle();
    }
}