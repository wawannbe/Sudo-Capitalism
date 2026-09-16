package com.sudocapitalism.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
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

        Skin buttonSkin  = new Skin(Gdx.files.internal("ui/buttons.json"));

        Button startButton = new Button(buttonSkin.optional("start", Button.ButtonStyle.class));
        startButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(main.getScreenList().get(1));
            }
        });

        Button optionsButton = new Button(buttonSkin.optional("options", Button.ButtonStyle.class));
        optionsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(main.getScreenList().get(2));
            }
        });

        Button exitButton = new Button(buttonSkin.optional("exit", Button.ButtonStyle.class));
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        table.add(startButton).width(480).height(44f).center();
        table.row();
        table.add(optionsButton).padTop(40f).width(480).height(44f);
        table.row();
        table.add(exitButton).padTop(40f).width(480).height(44f);

        stage.addActor(table);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
