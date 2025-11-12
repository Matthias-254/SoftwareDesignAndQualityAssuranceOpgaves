package opgave2_strategy.exercise1;

public class RedHeadDuck extends Duck{
    public RedHeadDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    public void display() {
        System.out.println("I'm a Red Headed Duck");
    }
}
