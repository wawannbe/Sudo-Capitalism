package com.sudocapitalism.gameState.production;

import com.sudocapitalism.item.Item;

public class Product extends Item {

    private double price;
    protected static final double DEFAULT_PRICE = 10;

    public Product(String name, String description) {

        super(name, description);
        this.price = DEFAULT_PRICE;
    }

    public Product(String name) {
        this(name, "");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
