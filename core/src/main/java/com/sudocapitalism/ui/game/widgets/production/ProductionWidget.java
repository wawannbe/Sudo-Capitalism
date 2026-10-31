package com.sudocapitalism.ui.game.widgets.production;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.company.production.Production;
import com.sudocapitalism.company.production.ProductionListener;

/**
 * Widget to allow displaying infos about a production in the game and managing it.
 *
 * @author Elmouu
 */
public class ProductionWidget extends Table implements ProductionListener {

    // ---------< Attributes >---------

    // ---< ID >---

    /** Counter used to handle the auto-generated IDs */
    private static int ID_COUNTER = 0;

    /** The ID of the widget - used to avoid multiple widgets pointing at the same production */
    private final int ID;


    // ---< GameState & Main >---

    /** The GameState used in the widget */
    private final GameState gameState;

    /** The Main used in the widget */
    private final Main main;


    // ---< Level >---

    /** Label showing the level of the widget's assigned production */
    private Label LevelLabel;

    /** Button to upgrade its production's level */
    private TextButton upgradeLevelButton;

    /** Little progress bar to show the level in a cooler way */
    private ProgressBar levelBar;


    // ---------< Constructor >---------

    /**
     * Creates a new widget to manage a production
     *
     * @param main The main class
     * @param gameState The game state
     */
    public ProductionWidget(Main main, GameState gameState) {

        this.ID = ID_COUNTER ++;

        this.main = main;

        this.gameState = gameState;
        this.gameState.getCompany().addProductionListener(this, this.ID);

        this.setBackground(this.main.getUiSkin().getDrawable("textfield"));

        this.add(new Label(this.gameState.getCompany().getProducedProduct(this.ID).getName() + " production", this.main.getUiSkin())).colspan(3).row();

        this.initLevelSection();
    }


    // ---------< Level >---------

    /**
     * Initializes the level management section of the widget
     */
    public void initLevelSection() {

        this.levelBar = new ProgressBar(0, Production.getMaxLevel(), 1f, false, this.main.getUiSkin());
        this.levelBar.setAnimateDuration(0.2f);
        this.levelBar.setValue(this.gameState.getCompany().getProductionLevel(this.ID));

        if (this.main.getBackgroundColor() == Color.BLACK) {    // Avoids having black on black
            this.levelBar.setColor(Color.GRAY);

        } else {
            this.levelBar.setColor(this.main.getBackgroundColor());
        }

        this.LevelLabel = new Label(String.format("Production level: %d", this.gameState.getCompany().getProductionLevel(this.ID)), this.main.getUiSkin());

        this.upgradeLevelButton = new TextButton("^", main.getUiSkin());

        if (this.main.getBackgroundColor() == Color.BLACK) {    // Avoids having black on black
            this.upgradeLevelButton.setColor(Color.GRAY);

        } else {
            this.upgradeLevelButton.setColor(this.main.getBackgroundColor());
        }

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

    /**
     * Updates the labels/buttons when the listener is triggered
     */
    @Override
    public void productionLevelUpgraded() {

        this.LevelLabel.setText(String.format("Production level: %d", this.gameState.getCompany().getProductionLevel(this.ID)));
        this.levelBar.setValue(this.gameState.getCompany().getProductionLevel(this.ID));

        if (this.gameState.getCompany().getProductionLevel(this.ID) == Production.getMaxLevel()) {

            this.upgradeLevelButton.setVisible(false);
        }
    }
}
