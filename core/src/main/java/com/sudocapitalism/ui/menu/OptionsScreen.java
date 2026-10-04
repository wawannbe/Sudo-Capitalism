package com.sudocapitalism.ui.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sudocapitalism.Main;
import com.sudocapitalism.ui.utils.ColorWrapper;

import java.util.EnumSet;

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
        table.setDebug(false);

        Label backgroundColorLabel = new Label("Background color: ", main.uiSkin);
        table.add(backgroundColorLabel).row();

        SelectBox<String> backgroundColor = new SelectBox<>(main.uiSkin);
        backgroundColor.setItems(ColorWrapper.getColorsList());

        backgroundColor.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.backgroundColor = ColorWrapper.getColor(backgroundColor.getSelected().toUpperCase());
            }
        });

        table.add(backgroundColor).width(300f).padTop(5f).row();


        // ---< Back button >--st

        Button backButton = new TextButton("Back", main.uiSkin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(main.getScreenList().get("HomeScreen"));
            }
        });

        table.add(backButton).width(100f).padTop(20f);

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
