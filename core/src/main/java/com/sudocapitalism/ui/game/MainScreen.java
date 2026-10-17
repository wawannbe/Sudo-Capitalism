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
import com.sudocapitalism.ui.game.dashboards.ProductionDashboard;
import com.sudocapitalism.ui.game.layout.MainScreenLayout;
import com.sudocapitalism.ui.game.layout.SideBar;
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

        Table layout = new MainScreenLayout(this.main, this.gameState);

        stage.addActor(layout);
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
