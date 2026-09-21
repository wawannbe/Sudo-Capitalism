package com.sudocapitalism.ui.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.gameState.GameStateListener;

public class GameScreen implements Screen, GameStateListener {

    private final Main main;

    private final GameState gameState;

    private Stage stage;

    public GameScreen(Main main, GameState gameState) {
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

        Label companyName = new Label(gameState.getPlayerCompany().getName(), main.uiSkin);
        Label companyMoney = new Label(String.valueOf(gameState.getPlayerCompany().getMoney()), main.uiSkin);
        TextButton hireButton = new TextButton("Hire", main.uiSkin);
        TextButton fireButton = new TextButton("Fire", main.uiSkin);

        table.add(companyName).top().left();
        table.add(companyMoney).top().right();

        table.row();
        table.add(new Table()).expand().colspan(2);

        table.row();
        table.add(hireButton).bottom().width(100f);
        table.add(fireButton).bottom().width(100f);

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

    @Override
    public void updateMoney(GameState gameState) {

    }
}
