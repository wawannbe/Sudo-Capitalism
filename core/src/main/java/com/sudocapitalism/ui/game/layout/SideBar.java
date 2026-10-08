package com.sudocapitalism.ui.game.layout;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;

public class SideBar extends Table {

    public SideBar(Main main, GameState gameState) {

        this.defaults().width(200f);

        TextButton employeesDashboardButton = new TextButton("Manage employees", main.getUiSkin());
        TextButton marketDashboardButton = new TextButton("Manage market", main.getUiSkin());
        TextButton productionDashboardButton = new TextButton("Manage products", main.getUiSkin());

        TextButton nextWeekButton = new TextButton("Start next week", main.getUiSkin());
        nextWeekButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.nextWeek();
            }
        });

        this.add(employeesDashboardButton).row();
        this.add(marketDashboardButton).row();
        this.add(productionDashboardButton).row();

        this.add(nextWeekButton);
    }
}
