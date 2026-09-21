package com.sudocapitalism;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.ui.game.DebugScreen;
import com.sudocapitalism.ui.game.GameScreen;
import com.sudocapitalism.ui.menu.MainScreen;
import com.sudocapitalism.ui.menu.NewGameScreen;
import com.sudocapitalism.ui.menu.OptionsScreen;
import com.sudocapitalism.ui.menu.LoadScreen;
import java.util.HashMap;
import java.util.Map;

public class Main extends Game {

    public Skin uiSkin;
    private final Color backgroundColor = Color.SLATE;

    private Map<String, Screen> screenList;

    public GameState gameState = new GameState();

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public Map<String, Screen> getScreenList() {
        return screenList;
    }

    @Override
    public void create() {

        uiSkin = new Skin(Gdx.files.internal("ui/uiskin.json"));

        this.screenList = new HashMap<>();
        screenList.put("MainScreen", new MainScreen(this));
        screenList.put("LoadScreen", new LoadScreen(this));
        screenList.put("OptionsScreen", new OptionsScreen(this));
        screenList.put("NewGameScreen", new NewGameScreen(this, gameState));
        screenList.put("GameScreen", new GameScreen(this, gameState));

        DebugScreen debugScreen = new DebugScreen(this, gameState);
        gameState.addListener(debugScreen);
        screenList.put("DebugScreen", debugScreen);

        setScreen(screenList.get("MainScreen"));
    }
}
