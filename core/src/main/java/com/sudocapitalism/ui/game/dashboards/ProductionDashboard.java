package com.sudocapitalism.ui.game.dashboards;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.gameState.production.Production;
import com.sudocapitalism.gameState.production.ProductionListener;

public class ProductionDashboard extends Table implements ProductionListener {

    // ---------< Attributes >---------

    // ---< Level >---


    private final Label LevelLabel;

    private final TextButton upgradeLevelButton;

    private final ProgressBar levelBar;

    // ---< Capacity >---

    private final Label CapacityLabel;

    private final TextButton upgradeCapacityButton;

    private final ProgressBar capacityBar;

    // ---------< Constructor >---------
    public ProductionDashboard(Main main, GameState gameState) {

        this.setDebug(false);

        gameState.getCompany().addProductionListener(this);

        this.levelBar = new ProgressBar(0, Production.getMaxLevel(), 1f, false, main.getUiSkin());
        this.levelBar.setAnimateDuration(0.2f);
        this.levelBar.setValue(gameState.getCompany().getProductionLevel());

        this.LevelLabel = new Label(String.format("Production level: %d", gameState.getCompany().getProductionLevel()), main.getUiSkin());

        this.upgradeLevelButton = new TextButton("^", main.getUiSkin());
        this.upgradeLevelButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.getCompany().upgradeProductionLevel();
            }
        });
        this.add(this.LevelLabel).padRight(10f);
        this.add(levelBar);
        this.add(this.upgradeLevelButton).row();


        this.capacityBar = new ProgressBar(0, Production.getMaxCapacity(), 100f, false, main.getUiSkin());
        this.capacityBar.setAnimateDuration(0.2f);
        this.capacityBar.setValue(gameState.getCompany().getProductionCapacity());

        this.CapacityLabel = new Label(String.format("Capacity: %d", gameState.getCompany().getProductionCapacity()), main.getUiSkin());

        this.upgradeCapacityButton = new TextButton("^", main.getUiSkin());
        this.upgradeCapacityButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.getCompany().upgradeCapacityLevel();
            }
        });
        this.add(this.CapacityLabel).padRight(10f);
        this.add(capacityBar);
        this.add(this.upgradeCapacityButton);
    }

    @Override
    public void productionLevelUpgraded(GameState gameState) {

        this.LevelLabel.setText(String.format("Production level: %d", gameState.getCompany().getProductionLevel()));
        this.levelBar.setValue(gameState.getCompany().getProductionLevel());

        if (gameState.getCompany().getProductionLevel() == Production.getMaxLevel()) {

            this.upgradeLevelButton.setVisible(false);
        }
    }

    @Override
    public void productionCapacityUpgraded(GameState gameState) {

        this.CapacityLabel.setText(String.format("Capacity: %d", gameState.getCompany().getProductionCapacity()));
        this.capacityBar.setValue(gameState.getCompany().getProductionCapacity());

        if (gameState.getCompany().getProductionCapacity() == Production.getMaxCapacity()) {

            this.upgradeCapacityButton.setVisible(false);
        }
    }
}
