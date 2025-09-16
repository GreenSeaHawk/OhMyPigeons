package org.example;

public class Card {
    private final String name;
    private final String description;
//    private final Runnable action;

    public Card(String name, String description) {
        this.name = name;
        this.description = description;
//        this.action = action;
    }

//    public void performAction() {
//        action.run();
//    }

    public String getName() { return name; }
    public String getDescription() { return description; }


}
