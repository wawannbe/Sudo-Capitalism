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

public class SaveLoadScreen implements Screen {

    private final Main main;

    private Stage stage;

    public SaveLoadScreen(Main main) {
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

        Button backButton = new Button(buttonSkin.optional("back_arrow", Button.ButtonStyle.class));
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(main.getScreenList().getFirst());
            }
        });

        Button newGameButton = new Button(buttonSkin.optional("new_game", Button.ButtonStyle.class));
        newGameButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // TODO start a new game
            }
        });

        Button loadGameButton = new Button(buttonSkin.optional("load_game", Button.ButtonStyle.class));
        loadGameButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                // TODO load a saved game
            }
        });

        table.add(newGameButton).width(480).height(44f).center();
        table.row();
        table.add(loadGameButton).padTop(40f).width(480).height(44f).center();
        table.row();
        table.add(backButton).padTop(80f).width(28f).height(44f).center();

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

    }
}
