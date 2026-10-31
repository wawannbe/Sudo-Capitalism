package com.sudocapitalism.gameState.production;

import com.sudocapitalism.gameState.GameState;
import java.util.*;

/**
 * Represents a production the player can create in its company.
 * A company can own multiple productions.
 *
 * @author Elmouu
 */
public class Production {

    // ---------< Attributes >---------

    // ---< Level >---

    /** The maximum level a production can be */
    private static final int MAX_LEVEL = 10;

    /** The current level of the production */
    private int level;


    // ---< Capacity >---

    /** The maximum level a production can be */
    private static final int MAX_CAPACITY = 10000;

    /* Total amount of Products that can be stored in the Production */
    private int capacity;


    // ---< Product >---

    /** The product selected to be produced in this production */
    private final Product producedProduct;

    // ---< Inventory >---

    /** The inventory is shared between all productions */
    private static final Map<Product, Integer> INVENTORY = new HashMap<>();

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
    public Production(GameState gameState, Product product) {

        this.productionListeners = new ArrayList<>();

        this.gameState = gameState;

        this.level = 1;
        this.capacity = 100;

        this.producedProduct = product;
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


    // ---------< Level >---------

    public static int getMaxLevel() {
        return MAX_LEVEL;
    }

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

            notifyLevelUpgraded();

            return true;

        } else {

            return false;
        }
    }

    // ---< Notification >---

    /**
     * Notifies all the listeners about the production being upgraded
     */
    public void notifyLevelUpgraded() {

        for (ProductionListener productionListener : this.productionListeners) {
            productionListener.productionLevelUpgraded();
        }
    }


    // ---------< Capacity >---------

    /**
     * Returns the maximum capacity the productions can be
     *
     * @return an int representing the max capacity
     */
    public static int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    /**
     * Returns the current capacity of the inventory
     *
     * @return an int representing the current capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Upgrades the inventory's capacity until the maximum capacity is reached
     */
    public void upgradeCapacity() {

        if (this.capacity < MAX_CAPACITY) {
            this.capacity += 100;
        }

        notifyCapacityUpgraded();
    }

    // ---< Notification >---

    /**
     * Notifies all the listeners about the production being upgraded
     */
    public void notifyCapacityUpgraded() {

        for (ProductionListener productionListener : this.productionListeners) {
            productionListener.productionCapacityUpgraded();
        }
    }


    // ---------< Product >---------

    /**
     * Returns the product being produced in this production
     *
     * @return The Product
     */
    public Product getProducedProduct() {
        return this.producedProduct;
    }


    // ---------< Inventory >---------

    /**
     * Returns a read only copy of the inventory
     *
     * @return Map<Product, Integer> The inventory
     */
    public Map<Product, Integer> getInventory() {
        return Collections.unmodifiableMap(INVENTORY);
    }

    /**
     * Returns the total amount of items in the inventory regardless of their type
     *
     * @return int The amount of items in the inventory
     */
    public int usedCapacity() {

        int amount = 0;

        for (Map.Entry<Product, Integer> entry : INVENTORY.entrySet()) {

            amount += entry.getValue();
        }

        return amount;
    }

    /**
     * Adds a given Product to the inventory.
     * If the Product is already in the inventory, its amount is increased.
     *
     * @param product The Product to be added
     * @param amount The amount of this product to be added
     */
    public void addToInventory(Product product, int amount) {

        if (this.usedCapacity() + amount <= this.capacity) {        // Checks if there is enough capacity to hold the new Products

            if (INVENTORY.containsKey(product)) {              // Checks if the Product is already registered in the inventory

                INVENTORY.replace(product, INVENTORY.get(product) + amount);  // Updates the amount if that's the case

            } else {
                INVENTORY.put(product, amount);                                    // Registers it if not
            }
        }
    }

    /**
     * Remove a given amount of a given product from the inventory
     *
     * @param product The product to remove
     * @param amount The amount of this product to be removed
     */
    public boolean removeFromInventory(Product product, int amount) {

        if (INVENTORY.containsKey(product)) {      // Checks whether the product is actually in stock

            if (amount >= INVENTORY.get(product)) {

                INVENTORY.replace(product, INVENTORY.get(product) - amount);

                return true;
            }
            return false;
        }
        return false;
    }
}
