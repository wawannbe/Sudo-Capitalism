package com.sudocapitalism.ui.game.layout;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;

public class TopBar extends Table {

    private final Label companyMoneyLabel;

    private final Label weekLabel;

    public TopBar(Main main, GameState gameState) {

        this.defaults().pad(10f, 10f, 10f, 10f);
        this.setBackground(main.uiSkin.newDrawable("white", new Color(0.2f, 0.2f, 0.25f, 0.5f)));

        Label companyNameLabel = new Label(gameState.getCompany().getName(), main.uiSkin);
        this.companyMoneyLabel = new Label(String.format("%.2f $", gameState.getCompany().getMoney()), main.uiSkin);

        this.weekLabel = new Label(String.format("Week %d", gameState.getWeek()), main.uiSkin);

        this.add(companyNameLabel).center();
        this.add(this.companyMoneyLabel).right();

        this.add(this.weekLabel).left();
    }

    public Label getCompanyMoneyLabel() {
        return companyMoneyLabel;
    }

    public Label getWeekLabel() {
        return weekLabel;
    }
}
