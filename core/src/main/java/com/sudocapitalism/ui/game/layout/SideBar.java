package com.sudocapitalism.ui.game.layout;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextTooltip;
import com.badlogic.gdx.scenes.scene2d.ui.TooltipManager;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;

public class SideBar extends Table {

    public SideBar(Main main, GameState gameState) {

        this.defaults().width(50f);

        TooltipManager tooltipManager = new TooltipManager();
        tooltipManager.instant();

        TextButton employeesDashboardButton = new TextButton("E", main.getUiSkin());
        employeesDashboardButton.addListener(new TextTooltip("Manage employees", tooltipManager, main.getUiSkin()));

        TextButton marketDashboardButton = new TextButton("M", main.getUiSkin());
        marketDashboardButton.addListener(new TextTooltip("Manage the market", tooltipManager, main.getUiSkin()));

        TextButton productionDashboardButton = new TextButton("P", main.getUiSkin());
        productionDashboardButton.addListener(new TextTooltip("Manage the production", tooltipManager, main.getUiSkin()));

        TextButton nextWeekButton = new TextButton(">>", main.getUiSkin());
        nextWeekButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.nextWeek();
            }
        });
        nextWeekButton.addListener(new TextTooltip("Start the next week", tooltipManager, main.getUiSkin()));

        this.add(employeesDashboardButton).top().row();
        this.add(marketDashboardButton).row();
        this.add(productionDashboardButton).row();

        this.add(nextWeekButton).bottom();
    }
}
