package opgave7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class CounterTest {
    private Counter counter;

    @BeforeEach
    public void setUp() throws Exception {
        counter = new Counter();
    }

    @Test
    void increment_once_increasesValueByOne() {
        counter.increment();
        assertEquals(1, counter.getValue());
    }

    @Test
    void increment_multipleTimes_increasesValueCorrectly() {
        counter.increment();
        counter.increment();
        counter.increment();
        assertEquals(3, counter.getValue());
    }

    @Test
    void decrement_whenValueAboveZero_decreasesValueByOne() {
        counter.increment(); // value = 1

        counter.decrement();
        assertEquals(0, counter.getValue());
    }

    @Test
    void decrement_atZero_throwsException() {

        IllegalStateException ex = assertThrows(
                IllegalStateException.class,
                () -> counter.decrement()
        );

        assertEquals("Counter cannot go below zero", ex.getMessage());
    }

    @Test
    void reset_setsValueToZero() {
        counter.increment();
        counter.increment(); // value = 2

        counter.reset();

        assertEquals(0, counter.getValue());
    }

    @Test
    void getValue_initiallyZero() {
        assertEquals(0, counter.getValue());
    }
}