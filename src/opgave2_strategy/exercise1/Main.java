package opgave2_strategy.exercise1;

public class Main {
    public static void main(String[] args) {
        Duck d = new DecoyDuck();
        d.display();
        d.performFly();
        d.performQuack();
    }
}
