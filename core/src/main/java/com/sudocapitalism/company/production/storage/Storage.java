package com.sudocapitalism.company.production.storage;

import com.sudocapitalism.company.production.Product;
import com.sudocapitalism.company.production.Production;

import java.util.*;

/**
 * Represents the products inventory of a company.
 * It is shared between all the {@link Production} that the company owns.
 *
 * @author Elmouu
 */
public class Storage {

    // ---------< Attributes >---------

    // ---< Capacity >---

    /** The maximum capacity the inventory can be */
    private static final int MAX_CAPACITY = 1000000;

    /* Total amount of Products that can currently be stored in the Production */
    private int capacity;


    // ---< Storage >---

    /** The actual storage of the inventory that holds all the Products */
    private static final Map<Product, Integer> STORAGE = new HashMap<>();


    // ---< Listeners >---

    private final List<StorageListener> storageListeners;


    // ---------< Constructor >---------

    public Storage() {

        this.capacity = 100;    // Default capacity is 100 items

        this.storageListeners = new ArrayList<>();
    }


    // ---------< Listeners >---------

    public void addStorageListener(StorageListener storageListener) {
        this.storageListeners.add(storageListener);
    }

    // ---< Notification >---

    /**
     * Notifies all the listeners about the production being upgraded
     */
    public void notifyStorageCapacityUpgraded() {

        for (StorageListener storageListener : this.storageListeners) {
            storageListener.storageCapacityUpgraded();
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
     * Returns the current capacity of the storage
     *
     * @return an int representing the current capacity
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Upgrades the storage's capacity until the maximum capacity is reached
     */
    public void upgradeCapacity() {

        if (capacity < MAX_CAPACITY) {
            capacity += 100;
        }

        notifyStorageCapacityUpgraded();
    }


    // ---------< Storage >---------

    /**
     * Returns a read only copy of the storage
     *
     * @return Map<Product, Integer> The storage
     */
    public Map<Product, Integer> getStorage() {
        return Collections.unmodifiableMap(STORAGE);
    }

    /**
     * Returns the total amount of items in the storage regardless of their type
     *
     * @return int The amount of items in the storage
     */
    public int usedCapacity() {

        int amount = 0;

        for (Map.Entry<Product, Integer> entry : STORAGE.entrySet()) {

            amount += entry.getValue();
        }

        return amount;
    }

    /**
     * Adds a given Product to the storage.
     * If the Product is already in the storage, its amount is increased.
     *
     * @param product The Product to be added
     * @param amount The amount of this product to be added
     */
    public void addToStorage(Product product, int amount) {

        if (this.usedCapacity() + amount <= capacity) {        // Checks if there is enough capacity to hold the new Products

            if (STORAGE.containsKey(product)) {              // Checks if the Product is already registered in the inventory

                STORAGE.replace(product, STORAGE.get(product) + amount);  // Updates the amount if that's the case

            } else {
                STORAGE.put(product, amount);                                    // Registers it if not
            }
        }
    }

    /**
     * Remove a given amount of a given product from the storage
     *
     * @param product The product to remove
     * @param amount The amount of this product to be removed
     */
    public boolean removeFromStorage(Product product, int amount) {

        if (STORAGE.containsKey(product)) {      // Checks whether the product is actually in stock

            if (amount >= STORAGE.get(product)) {

                STORAGE.replace(product, STORAGE.get(product) - amount);

                return true;
            }
            return false;
        }
        return false;
    }
}
