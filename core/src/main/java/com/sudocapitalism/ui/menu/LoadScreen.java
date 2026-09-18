package com.sudocapitalism.ui.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sudocapitalism.Main;

public class LoadScreen implements Screen {

    private final Main main;

    private Stage stage;

    public LoadScreen(Main main) {
        this.main = main;
    }

    @Override
    public void show() {

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);

        table.setDebug(false);

        Button backButton = new TextButton("Back", main.uiSkin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(main.getScreenList().get("MainScreen"));
            }
        });

        Button newGameButton = new TextButton("New game", main.uiSkin);
        newGameButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(main.getScreenList().get("NewGameScreen"));
            }
        });

        Button loadGameButton = new TextButton("Load game", main.uiSkin);
        loadGameButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // TODO load a saved game
            }
        });

        table.defaults().width(100f).padBottom(10f);
        table.add(newGameButton);
        table.row();
        table.add(loadGameButton);
        table.row();
        table.add(backButton);

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
