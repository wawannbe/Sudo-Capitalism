package com.sudocapitalism.gameState.production;

import com.sudocapitalism.gameState.GameState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Production {

    private static final int MAX_LEVEL = 10;
    private int level;

    private final Map<Product, Integer> inventory;

    private final List<ProductionListener> productionListeners;

    private final GameState gameState;

    public Production(GameState gameState) {

        this.productionListeners = new ArrayList<>();

        this.gameState = gameState;

        this.level = 1;

        this.inventory = new HashMap<>();
    }

    public boolean addProductionListener(ProductionListener productionListener) {
        return this.productionListeners.add(productionListener);
    }

    public boolean removeProductionListener(ProductionListener  productionListener) {
        return this.productionListeners.remove(productionListener);
    }

    public void notifyProductionHasBeenUpgraded() {

        for (ProductionListener productionListener : this.productionListeners) {
            productionListener.productionHasBeenUpgraded(this.gameState);
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean upgradeProduction() {

        if (this.level < 10) {

            this.level ++;

            notifyProductionHasBeenUpgraded();

            return true;

        } else {

            return false;
        }
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
