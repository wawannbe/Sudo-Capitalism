package com.sudocapitalism.ui.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;

public class DebugScreen implements Screen {

    private final Main main;

    private final GameState gameState;

    private Stage stage;

    public DebugScreen (Main main, GameState gameState) {
        this.main = main;

        this.gameState = gameState;
    }

    @Override
    public void show() {

        // ---< Setup >---

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);

        table.setDebug(true);

        Label playerFirstName = new Label(gameState.getPlayer().getFirstName(), main.uiSkin);
        Label playerLastName = new Label(gameState.getPlayer().getLastName(), main.uiSkin);
        Label playerGenre = new Label(gameState.getPlayer().getGenre().toString(), main.uiSkin);

        Label companyName = new Label(gameState.getPlayerCompany().getName(), main.uiSkin);

        table.defaults().padBottom(5f);
        table.add(playerFirstName);
        table.row();
        table.add(playerLastName);
        table.row();
        table.add(playerGenre);
        table.row();
        table.add(companyName);

        stage.addActor(table);
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
