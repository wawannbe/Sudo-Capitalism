package com.sudocapitalism.ui.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sudocapitalism.Main;

public class OptionsScreen implements Screen  {

    private final Main main;

    private Stage stage;

    public OptionsScreen(Main main) {
        this.main = main;
    }

    @Override
    public void show() {

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);

        table.setDebug(true);

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

    }
}
