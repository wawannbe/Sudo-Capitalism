package com.sudocapitalism.item;

/**
 * Representation of an in-game item
 *
 * @author wawannbe
 * @version 1.0.0
 */
public abstract class Item {

    protected String name;
    protected String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name) {
        this(name, "No description*");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
