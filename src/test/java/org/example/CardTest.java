package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {


    @Test
    void testGetName() {
        String name = "AHHHH!!";
        String description = "All other players return 1 pigeon to the flock";

        Card card1 = new Card(name,description);

        assertEquals(name, card1.getName());
    }

    @Test
    void testGetDescription() {
        String name = "AHHHH!!";
        String description = "All other players return 1 pigeon to the flock";

        Card card1 = new Card(name,description);

        assertEquals(description, card1.getDescription());
    }


}
