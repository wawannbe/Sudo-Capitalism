package com.sudocapitalism.ui.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sudocapitalism.Main;
import com.sudocapitalism.company.CompanyListener;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.gameState.GameStateListener;

public class MainScreen implements Screen, GameStateListener, CompanyListener {

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

        Table topBar = new Table();
        topBar.setBackground(main.uiSkin.newDrawable("white", new Color(0.2f, 0.2f, 0.25f, 0.5f)));

        Label companyName = new Label(gameState.getPlayerCompany().getName(), main.uiSkin);

        topBar.add(companyName).top().center().pad(10f, 10f, 10f, 10f);

        root.add(topBar).pad(10f, 0, 10f, 0).row();


        // ---< Center part of the screen >---

        Table dashboard = new Table();
        dashboard.setBackground(main.uiSkin.newDrawable("white", new Color(0.2f, 0.2f, 0.25f, 0.5f)));

        root.add(dashboard).expand().fill().pad(0, 10f, 0, 10f).row();


        // ---< Bottom navigation bar >---

        Table buttonBar = new Table();
        buttonBar.setBackground(main.uiSkin.newDrawable("white", new Color(0.2f, 0.2f, 0.25f, 0.5f)));

        TextButton employeesDashboardButton = new TextButton("Manage employees", main.uiSkin);
        TextButton marketDashboardButton = new TextButton("Manage market", main.uiSkin);
        TextButton productionDashboardButton = new TextButton("Manage products", main.uiSkin);

        buttonBar.defaults().pad(10f, 10f, 10f, 10f);

        buttonBar.add(employeesDashboardButton).width(200f);
        buttonBar.add(marketDashboardButton).width(200f);
        buttonBar.add(productionDashboardButton).width(200f);

        root.add(buttonBar).pad(10f, 0, 10f, 0);

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

    @Override
    public void updateMoney(GameState gameState) {

    }

    @Override
    public void employeesListChanged() {
        /* do nothing */
    }
}
