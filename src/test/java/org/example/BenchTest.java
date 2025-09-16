package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BenchTest {

    Bench bench = new Bench(1);

    @Test
    void testGetNumPigeons() {
        assertEquals(3, bench.getNumPigeons());
    }

    @Test
    void testAddPigeons() {
        bench.addPigeons(2);
        assertEquals(5, bench.getNumPigeons());
    }

    @Test
    void testSubtractPigeons() {
        bench.subtractPigeons(1);
        assertEquals(2, bench.getNumPigeons());
    }

    @Test
    void testGetPlayer() {
        assertEquals(1, bench.getPlayer());
    }
}
