package com.sudocapitalism.ui.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.gameState.GameStateListener;

public class DebugScreen implements Screen, GameStateListener {

    private final Main main;

    private final GameState gameState;

    private Stage stage;

    private Label companyMoney;

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

        table.setDebug(false);

        Label playerFirstName = new Label(gameState.getPlayer().getFirstName(), main.uiSkin);
        Label playerLastName = new Label(gameState.getPlayer().getLastName(), main.uiSkin);
        Label playerGenre = new Label(gameState.getPlayer().getGenre().toString(), main.uiSkin);

        Label companyName = new Label(gameState.getPlayerCompany().getName(), main.uiSkin);
        companyMoney = new Label(String.valueOf(gameState.getPlayerCompany().getMoney()) + '$', main.uiSkin);


        TextButton addMoneyButton = new TextButton("Add 10$", main.uiSkin);
        addMoneyButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.addMoney(10);
                gameState.notifyMoneyChanged();
            }
        });

        TextButton spendMoneyButton = new TextButton("Spend 10$", main.uiSkin);
        spendMoneyButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.spendMoney(10);
                gameState.notifyMoneyChanged();
            }
        });

        table.defaults().padBottom(5f).padRight(10f);
        table.add(playerFirstName);
        table.add(playerLastName);
        table.add(playerGenre);

        table.add(companyName);
        table.add(companyMoney);
        table.add(addMoneyButton).width(100f);
        table.add(spendMoneyButton).width(100f);

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
        companyMoney.setText(String.valueOf(gameState.getPlayerCompany().getMoney()) + '$');
    }
}
