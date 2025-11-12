package opgave2_strategy.exercise1;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        MallardDuck	mallard = new MallardDuck();
        RubberDuck	rubberDuckie = new RubberDuck();
        DecoyDuck	decoy = new DecoyDuck();

        mallard.performFly();
        mallard.setFlyBehavior(new FlyRocketPowered());
        mallard.performFly();

        ModelDuck	model = new ModelDuck();

        mallard.performQuack();
        rubberDuckie.performQuack();
        decoy.performQuack();

        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
        mallard.setFlyBehavior(new FlyNoWay());
    }
}
