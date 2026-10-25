package com.sudocapitalism.gameState.production;

import com.sudocapitalism.gameState.GameState;
import java.util.*;

public class Production {

    // ---------< Attributes >---------

    /** The maximum level a production can be */
    private static final int MAX_LEVEL = 10;

    /** The current level of the production */
    private int level;

    /** The products the production has in stock */
    private final Map<Product, Integer> inventory;

    /** Listeners that subscribes to the Production */
    private final List<ProductionListener> productionListeners;

    /** The GameState being used */
    private final GameState gameState;


    // ---------< Constructor >---------

    /**
     * Creates a new instance of a Production
     *
     * @param gameState The GameState to use in the Production
     */
    public Production(GameState gameState) {

        this.productionListeners = new ArrayList<>();

        this.gameState = gameState;

        this.level = 1;

        this.inventory = new HashMap<>();
    }


    // ---------< Listeners >---------

    /**
     * Registers a class in the listeners
     *
     * @param productionListener The class that listens to Production changes
     */
    public void addProductionListener(ProductionListener productionListener) {
        this.productionListeners.add(productionListener);
    }

    /**
     * Unregisters a class from the listeners
     *
     * @param productionListener The class to be removed
     */
    public void removeProductionListener(ProductionListener  productionListener) {
        this.productionListeners.remove(productionListener);
    }

    // ---< Notification >---

    /**
     * Notifies all the listeners about the production being upgraded
     */
    public void notifyProductionHasBeenUpgraded() {

        for (ProductionListener productionListener : this.productionListeners) {
            productionListener.productionHasBeenUpgraded(this.gameState);
        }
    }


    // ---------< Level >---------

    /**
     * Returns the current level of the Production
     *
     * @return int The level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the Production level to a given number
     *
     * @param level Must be between 1 ~ 10
     */
    public void setLevel(int level) {

        if (level >= 1 && level <= 10) {
            this.level = level;
        }
    }

    /**
     * Upgrades the production by increments
     *
     * @return boolean true if upgraded, false if not
     */
    public boolean upgradeProduction() {

        if (this.level < 10) {

            this.level ++;

            notifyProductionHasBeenUpgraded();

            return true;

        } else {

            return false;
        }
    }


    // ---------< Inventory >---------

    /**
     * Returns a read only copy of the inventory
     *
     * @return Map<Product, Integer> The inventory
     */
    public Map<Product, Integer> getInventory() {
        return Collections.unmodifiableMap(this.inventory);
    }

    /**
     * Adds a given Product to the inventory.
     * If the Product is already in the inventory, its amount is increased.
     *
     * @param product The Product to be added
     * @param amount The amount of this product to be added
     */
    public void addToInventory(Product product, int amount) {

        if (this.inventory.containsKey(product)) {
            this.inventory.replace(product, this.inventory.get(product) + amount);

        } else {
            this.inventory.put(product, amount);
        }
    }

    /**
     * Remove a given amount of a given product from the inventory
     *
     * @param product The product to remove
     * @param amount The amount of this product to be removed
     */
    public boolean removeFromInventory(Product product, int amount) {

        if (this.inventory.containsKey(product)) {      // Checks whether the product is actually in stock

            if (amount >= this.inventory.get(product)) {

                this.inventory.replace(product, this.inventory.get(product) - amount);

                return true;
            }
            return false;
        }
        return false;
    }
}
