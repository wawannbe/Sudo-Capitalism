package com.sudocapitalism.company.production;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.sudocapitalism.company.production.storage.Storage;
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


    // ---< Product >---

    /** The product selected to be produced in this production */
    private final Product producedProduct;


    // ---< Listeners >---

    /** Listeners that subscribes to the Production */
    private final List<ProductionListener> productionListeners;


    // ---< Game stuff >---

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


    // ---------< Product >---------

    /**
     * Returns the product being produced in this production
     *
     * @return The Product
     */
    public Product getProducedProduct() {
        return this.producedProduct;
    }
}
