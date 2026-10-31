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
import com.sudocapitalism.company.production.Production;

public class CapacityWidget extends Table implements StorageListener {

    /** Label showing the capacity of the widget's assigned production */
    private Label CapacityLabel;

    /** Button to upgrade its production's capacity */
    private TextButton upgradeCapacityButton;

    /** Little progress bar to show the capacity in a cooler way */
    private ProgressBar capacityBar;

    private final GameState gameState;

    public CapacityWidget(Main main, GameState gameState) {

        this.gameState = gameState;
        this.gameState.getCompany().addStorageListener(this);

        this.initCapacitySection(main);
    }

    /**
     * Initializes the capacity management section of the widget
     */
    public void initCapacitySection(Main main) {

        this.capacityBar = new ProgressBar(0, Storage.getMaxCapacity(), 100f, false, main.getUiSkin());
        this.capacityBar.setAnimateDuration(0.2f);
        this.capacityBar.setValue(gameState.getCompany().getStorageCapacity());

        if (main.getBackgroundColor() == Color.BLACK) {
            this.capacityBar.setColor(Color.GRAY);

        } else {
            this.capacityBar.setColor(main.getBackgroundColor());
        }

        this.CapacityLabel = new Label(String.format("Capacity: %d", gameState.getCompany().getStorageCapacity()), main.getUiSkin());

        this.upgradeCapacityButton = new TextButton("^", main.getUiSkin());
        this.upgradeCapacityButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.getCompany().upgradeCapacity();
            }
        });

        this.add(this.CapacityLabel).padRight(10f);
        this.add(capacityBar);
        this.add(this.upgradeCapacityButton);
    }

    /**
     * Updates the labels/buttons when the listener is triggered
     */
    @Override
    public void storageCapacityUpgraded() {

        this.CapacityLabel.setText(String.format("Capacity: %d", this.gameState.getCompany().getStorageCapacity()));
        this.capacityBar.setValue(this.gameState.getCompany().getStorageCapacity());

        if (this.gameState.getCompany().getStorageCapacity() == Storage.getMaxCapacity()) {

            this.upgradeCapacityButton.setVisible(false);
        }
    }
}
