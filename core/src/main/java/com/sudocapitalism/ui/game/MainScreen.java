package com.sudocapitalism.ui.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.gameState.GameStateListener;
import com.sudocapitalism.gameState.time.TimeListener;
import com.sudocapitalism.ui.game.layout.TopBar;

public class MainScreen implements Screen {

    private final Main main;

    private final GameState gameState;

    private Stage stage;



    public MainScreen(Main main, GameState gameState) {
        this.main = main;

        this.gameState = gameState;
    }

    @Override
    public void show() {

        // ---< Setup >---

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);


        // ---< Root container to hold the different sections >---

        Table root = new Table();
        root.setFillParent(true);
        root.setDebug(false);
        root.defaults().expandX();


        // ---< Top bar of the screens >---

        TopBar topBar = new TopBar(main, gameState);
        root.add(topBar).pad(10f, 0, 10f, 0).row();


        // ---< Center part of the screen >---

        Table buttonGroup = new Table();

        TextButton employeesDashboardButton = new TextButton("Manage employees", main.uiSkin);
        TextButton marketDashboardButton = new TextButton("Manage market", main.uiSkin);
        TextButton productionDashboardButton = new TextButton("Manage products", main.uiSkin);

        buttonGroup.defaults().width(200f);
        buttonGroup.add(employeesDashboardButton).row();
        buttonGroup.add(marketDashboardButton).row();
        buttonGroup.add(productionDashboardButton);

        Table dashboard = new Table();

        TextButton nextWeekButton = new TextButton("start next week", main.uiSkin);
        nextWeekButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.nextWeek();
                topBar.getWeekLabel().setText(String.format("Week %d", gameState.getWeek()));
            }
        });

        Label productionLevel = new Label(String.format("Lvl. %d", gameState.getCompany().getProductionLevel()), main.uiSkin);

        TextButton upgradeProduction = new TextButton("^", main.uiSkin);
        upgradeProduction.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.getCompany().upgradeProduction();
                productionLevel.setText(String.format("Lvl. %d", gameState.getCompany().getProductionLevel()));
                topBar.getCompanyMoneyLabel().setText(String.format("%.2f $", gameState.getCompany().getMoney()));

                if (gameState.getCompany().getProductionLevel() == 10) {
                    upgradeProduction.setText("Max level !");
                }
            }
        });

        dashboard.add(nextWeekButton).row();
        dashboard.add(productionLevel);
        dashboard.add(upgradeProduction);

        ScrollPane scrollPane = new ScrollPane(dashboard);

        Table window = new Table();
        window.setDebug(true);
        window.add(buttonGroup).expandY();
        window.add(scrollPane).expand();


        root.add(window).expand().fill().pad(0, 10f, 0, 10f);

        stage.addActor(root);
    }

    @Override
    public void render(float delta) {

        ScreenUtils.clear(main.getBackgroundColor());

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
