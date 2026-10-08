package com.sudocapitalism.gameState.production;

import java.util.HashMap;
import java.util.Map;

public class Production {

    private int level;

    private Map<Product, Integer> inventory;

    public Production() {

        this.level = 1;

        this.inventory = new HashMap<>();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Map<Product, Integer> getInventory() {
        return inventory;
    }

    public void addToInventory(Product product, int amount) {

        if (this.inventory.containsKey(product)) {
            this.inventory.replace(product, this.inventory.get(product) + amount);

        } else {
            this.inventory.put(product, amount);
        }
    }

    public void removeFromInventory(Product product, int amount) {

        if (this.inventory.containsKey(product)) {

            if (amount >= this.inventory.get(product)) {
                this.inventory.replace(product, this.inventory.get(product) - amount);

            }
        }
    }
}
