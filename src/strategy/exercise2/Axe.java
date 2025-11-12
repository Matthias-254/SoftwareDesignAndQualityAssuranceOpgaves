package strategy.exercise2;

public class Axe implements WeaponBehavior{
    @Override
    public void fight() {
        System.out.println("using my " + this.getClass().getSimpleName());
    }
}
