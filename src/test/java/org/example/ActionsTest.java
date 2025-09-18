package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActionsTest {

    Bench bench1;
    Bench bench2;
    Bench bench3;

    @BeforeEach
    void setUp() {
        bench1 = new Bench(1);
        bench2 = new Bench(2);
        bench3 = new Bench(3);
    }

    @Test
    void testRemoveOnePigeonFromEveryoneElse() {
        Actions.removeOnePigeonFromEveryoneElse(3, bench1, bench2, bench3);
        assertEquals(2, bench1.getNumPigeons());
        assertEquals(2, bench2.getNumPigeons());
        assertEquals(3, bench3.getNumPigeons());
    }

    @Test
    void testTakeOnePigeonFromAnotherPlayer() {
        // Simulate user typing "2" as the chosen target player
        String simulatedInput = "2\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Actions.takeOnePigeonFromAnotherPlayer(1, 2, bench1, bench2, bench3);

        // Bench2 should lose one, Bench1 should gain one
        assertEquals(4, bench1.getNumPigeons());
        assertEquals(2, bench2.getNumPigeons());
        assertEquals(3, bench3.getNumPigeons());
    }


}
