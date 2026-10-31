package com.sudocapitalism.ui.game.widgets.production;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.sudocapitalism.Main;
import com.sudocapitalism.company.production.storage.Storage;
import com.sudocapitalism.company.production.storage.StorageListener;
import com.sudocapitalism.gameState.GameState;


/**
 * Represents a widget that allow the player to see the capacity of the storage and upgrade it.
 *
 * @author Elmouu
 */
public class CapacityWidget extends Table implements StorageListener {

    // ---------< Attributes >--------

    // ---< Capacity >---

    /** Label showing the capacity of the widget's assigned production */
    private Label capacityLabel;

    /** Button to upgrade its production's capacity */
    private TextButton upgradeCapacityButton;

    /** Little progress bar to show the capacity in a cooler way */
    private ProgressBar capacityBar;


    // ---< Usage >---

    /** Label showing the current usage of the storage's capacity */
    private Label usageLabel;

    /** Bar that shows the current usage of the storage's capacity */
    private ProgressBar usageBar;


    // ---< Game stuff >---

    private final GameState gameState;


    // ---------< Constructor >--------

    public CapacityWidget(Main main, GameState gameState) {

        this.gameState = gameState;
        this.gameState.getCompany().addStorageListener(this);

        this.initCapacitySection(main);
        this.initUsageSection(main);
    }


    // ---------< Initialization >--------

    /**
     * Initializes the capacity management section of the widget
     */
    public void initCapacitySection(Main main) {

        this.capacityBar = new ProgressBar(0, Storage.getMaxCapacity(), 25f, false, main.getUiSkin());
        this.capacityBar.setAnimateDuration(0.2f);
        this.capacityBar.setValue(this.gameState.getCompany().getStorageCapacity());

        if (main.getBackgroundColor() == Color.BLACK) {
            this.capacityBar.setColor(Color.GRAY);

        } else {
            this.capacityBar.setColor(main.getBackgroundColor());
        }

        this.capacityLabel = new Label(String.format("Capacity: %d", gameState.getCompany().getStorageCapacity()), main.getUiSkin());

        this.upgradeCapacityButton = new TextButton("^", main.getUiSkin());
        this.upgradeCapacityButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.getCompany().upgradeCapacity();
            }
        });

        this.add(this.capacityLabel).padRight(10f);
        this.add(this.capacityBar);
        this.add(this.upgradeCapacityButton).row();
    }

    public void initUsageSection(Main main) {

        this.usageBar = new ProgressBar(0, Storage.getMaxCapacity(), 1, false, main.getUiSkin());
        this.usageBar.setAnimateDuration(0.2f);
        this.usageBar.setValue(this.gameState.getCompany().getUsedStorageCapacity());

        int usagePercentage = ((this.gameState.getCompany().getUsedStorageCapacity() / this.gameState.getCompany().getStorageCapacity()) * 100);

        if (usagePercentage >= 75) {
            this.usageBar.setColor(Color.RED);

        } else if (usagePercentage >= 50) {
            this.usageBar.setColor(Color.ORANGE);

        } else {
            this.usageBar.setColor(Color.GREEN);
        }

        this.usageLabel = new Label(String.format("%d%% of storage used", usagePercentage), main.getUiSkin());

        this.add(this.usageLabel).padRight((10f));
        this.add(this.usageBar);
    }


    // ---------< Update >--------

    /**
     * Updates the labels/buttons when the listener is triggered
     */
    @Override
    public void storageCapacityUpgraded() {

        this.capacityLabel.setText(String.format("Capacity: %d", this.gameState.getCompany().getStorageCapacity()));
        this.capacityBar.setValue(this.gameState.getCompany().getStorageCapacity());

        if (this.gameState.getCompany().getStorageCapacity() == Storage.getMaxCapacity()) {

            this.upgradeCapacityButton.setVisible(false);
        }
    }
}
