package opgave2_strategy.exercise2;

public class Knife implements WeaponBehavior{
    @Override
    public void fight() {
        System.out.println("using my " + this.getClass().getSimpleName());
    }
}
