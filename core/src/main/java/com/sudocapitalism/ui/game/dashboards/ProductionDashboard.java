package com.sudocapitalism.ui.game.dashboards;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.sudocapitalism.Main;
import com.sudocapitalism.company.CompanyListener;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.gameState.production.ProductionListener;

public class ProductionDashboard extends Table implements ProductionListener {

    private final Label productionLevelLabel;

    private final TextButton upgradeProductionButton;

    public ProductionDashboard(Main main, GameState gameState) {

        gameState.getCompany().getProduction().addProductionListener(this);

        this.productionLevelLabel = new Label(String.format("Lvl. %d", gameState.getCompany().getProductionLevel()), main.getUiSkin());

        this.upgradeProductionButton = new TextButton("^", main.getUiSkin());
        this.upgradeProductionButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.getCompany().upgradeProduction();
            }
        });
        this.add(this.productionLevelLabel);
        this.add(this.upgradeProductionButton);
    }

    @Override
    public void productionHasBeenUpgraded(GameState gameState) {
        this.productionLevelLabel.setText(String.format("Lvl. %d", gameState.getCompany().getProductionLevel()));

        if (gameState.getCompany().getProductionLevel() == 10) {
            this.upgradeProductionButton.setText("Max level !");
        }
    }
}
