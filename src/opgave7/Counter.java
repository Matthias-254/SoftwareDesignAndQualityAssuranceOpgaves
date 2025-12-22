package opgave7;

public class Counter {
    private int value = 0;

    public void increment() {
        value++;
    }

    public void decrement() {
        if (value == 0)
            throw new IllegalStateException("Counter cannot go below zero");
        value--;
    }

    public void reset() {
        value = 0;
    }

    public int getValue() {
        return value;
    }
}