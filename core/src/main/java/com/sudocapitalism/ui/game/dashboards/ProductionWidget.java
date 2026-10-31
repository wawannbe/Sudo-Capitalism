package com.sudocapitalism.ui.game.dashboards;

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

public class ProductionWidget extends Table implements ProductionListener {

    // ---------< Attributes >---------

    // ---< ID >---

    private static int idCounter = 0;
    private final int ID;

    // ---< GameState & Main >---

    private final GameState gameState;

    private final Main main;


    // ---< Level >---

    private Label LevelLabel;

    private TextButton upgradeLevelButton;

    private ProgressBar levelBar;


    // ---< Capacity >---

    private Label CapacityLabel;

    private TextButton upgradeCapacityButton;

    private ProgressBar capacityBar;


    // ---------< Constructor >---------

    public ProductionWidget(Main main, GameState gameState) {

        this.ID = idCounter++;

        this.setDebug(true);

        this.main = main;

        this.gameState = gameState;
        this.gameState.getCompany().addProductionListener(this, this.ID);

        this.add(new Label(this.gameState.getCompany().getProducedProduct(0).getName() + " production", this.main.getUiSkin())).colspan(3).row();

        this.initLevelSection();
        this.initCapacitySection();
    }


    // ---------< Level >---------

    public void initLevelSection() {

        this.levelBar = new ProgressBar(0, Production.getMaxLevel(), 1f, false, this.main.getUiSkin());
        this.levelBar.setAnimateDuration(0.2f);
        this.levelBar.setValue(this.gameState.getCompany().getProductionLevel(this.ID));

        this.LevelLabel = new Label(String.format("Production level: %d", this.gameState.getCompany().getProductionLevel(this.ID)), this.main.getUiSkin());

        this.upgradeLevelButton = new TextButton("^", main.getUiSkin());
        this.upgradeLevelButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.getCompany().upgradeProductionLevel(ID);
            }
        });

        this.add(this.LevelLabel).padRight(10f);
        this.add(levelBar);
        this.add(this.upgradeLevelButton).row();
    }

    @Override
    public void productionLevelUpgraded(GameState gameState) {

        this.LevelLabel.setText(String.format("Production level: %d", gameState.getCompany().getProductionLevel(this.ID)));
        this.levelBar.setValue(gameState.getCompany().getProductionLevel(this.ID));

        if (gameState.getCompany().getProductionLevel(this.ID) == Production.getMaxLevel()) {

            this.upgradeLevelButton.setVisible(false);
        }
    }


    // ---------< Capacity >---------

    public void initCapacitySection() {

        this.capacityBar = new ProgressBar(0, Production.getMaxCapacity(), 100f, false, this.main.getUiSkin());
        this.capacityBar.setAnimateDuration(0.2f);
        this.capacityBar.setValue(this.gameState.getCompany().getProductionCapacity(this.ID));

        this.CapacityLabel = new Label(String.format("Capacity: %d", this.gameState.getCompany().getProductionCapacity(this.ID)), this.main.getUiSkin());

        this.upgradeCapacityButton = new TextButton("^", main.getUiSkin());
        this.upgradeCapacityButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.getCompany().upgradeCapacityLevel(ID);
            }
        });

        this.add(this.CapacityLabel).padRight(10f);
        this.add(capacityBar);
        this.add(this.upgradeCapacityButton);
    }

    @Override
    public void productionCapacityUpgraded(GameState gameState) {

        this.CapacityLabel.setText(String.format("Capacity: %d", gameState.getCompany().getProductionCapacity(this.ID)));
        this.capacityBar.setValue(gameState.getCompany().getProductionCapacity(this.ID));

        if (gameState.getCompany().getProductionCapacity(this.ID) == Production.getMaxCapacity()) {

            this.upgradeCapacityButton.setVisible(false);
        }
    }
}
