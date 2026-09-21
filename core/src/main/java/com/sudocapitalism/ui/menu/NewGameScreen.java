package com.sudocapitalism.ui.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sudocapitalism.Main;
import com.sudocapitalism.character.Genre;
import com.sudocapitalism.gameState.GameState;

public class NewGameScreen implements Screen {

    private final Main main;

    private final GameState gameState;

    private Stage stage;

    public NewGameScreen(Main main, GameState gameState) {
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

        table.setDebug(false);


        // ---< Character creation >---

        Label  nameLabel = new Label("Who are you ?", main.uiSkin);

        TextField firstNameField = new TextField("", main.uiSkin);
        firstNameField.setMessageText("ex: John");

        TextField lastNameField = new TextField("", main.uiSkin);
        lastNameField.setMessageText("ex: Doe");

        CheckBox maleGenre = new CheckBox("Male", main.uiSkin);
        CheckBox femaleGenre = new CheckBox("Female", main.uiSkin);
        ButtonGroup<CheckBox> genreSelector = new ButtonGroup<>(maleGenre, femaleGenre);
        genreSelector.setMaxCheckCount(1);
        genreSelector.setMinCheckCount(1);
        genreSelector.setChecked("Female");


        // ---< Company creation >---

        Label companyNameLabel = new Label("Enter the name of your company", main.uiSkin);
        TextField companyNameField = new TextField("", main.uiSkin);
        companyNameField.setMessageText("ex: BananaCorp");


        // ---< Start button >---

        TextButton startButton = new TextButton("Start game", main.uiSkin);
        startButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

                gameState.getPlayer().setFirstName(firstNameField.getText());
                gameState.getPlayer().setLastName(lastNameField.getText());
                switch (genreSelector.getCheckedIndex()) {
                    case 0 -> gameState.getPlayer().setGenre(Genre.MALE);
                    case 1 -> gameState.getPlayer().setGenre(Genre.FEMALE);
                }

                if (!companyNameField.getText().isEmpty()) {
                    gameState.getPlayerCompany().setName(companyNameField.getText());
                }

                main.setScreen(main.getScreenList().get("GameScreen"));
            }
        });


        // ---< Back button >---p

        Button backButton = new TextButton("Back", main.uiSkin);
        backButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(main.getScreenList().get("LoadScreen"));
            }
        });


        // ---< Table >---

        table.add(nameLabel).colspan(2);
        table.row();
        table.add(firstNameField).width(300f).padTop(10f).colspan(2);
        table.row();
        table.add(lastNameField).width(300f).padTop(5f).colspan(2);

        table.row();
        table.add(maleGenre).padTop(5f);
        table.add(femaleGenre).padTop(5f);

        table.row();
        table.add(companyNameLabel).colspan(2).padTop(20f);
        table.row();
        table.add(companyNameField).width(300f).padTop(5f).colspan(2);

        table.row();
        table.add(startButton).width(100f).padTop(20f).colspan(2);

        table.row();
        table.add(backButton).width(100f).padTop(20f).colspan(2);

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
