package com.sudocapitalism.ui.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
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

public class MainScreen implements Screen {

    private final Main main;

    private Stage stage;

    public  MainScreen(Main main) {
        this.main = main;
    }

    @Override
    public void show() {

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setFillParent(true);

        table.setDebug(false);

        Button startButton = new TextButton("Start", main.uiSkin);
        startButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(main.getScreenList().get("LoadScreen"));
            }
        });

        Button optionsButton = new TextButton("options", main.uiSkin);
        optionsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(main.getScreenList().get("OptionsScreen"));
            }
        });

        Button exitButton = new TextButton("Exit", main.uiSkin);
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        table.defaults().width(100f).padBottom(10f);
        table.add(startButton);
        table.row();
        table.add(optionsButton);
        table.row();
        table.add(exitButton);

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
