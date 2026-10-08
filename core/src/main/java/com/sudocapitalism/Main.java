package com.sudocapitalism;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.ui.game.MainScreen;
import com.sudocapitalism.ui.menu.HomeScreen;
import com.sudocapitalism.ui.menu.NewGameScreen;
import com.sudocapitalism.ui.menu.OptionsScreen;
import com.sudocapitalism.ui.menu.LoadScreen;
import java.util.HashMap;
import java.util.Map;

public class Main extends Game {

    private Skin uiSkin;
    private Color backgroundColor;

    private Map<String, Screen> screenList;

    public GameState gameState = new GameState();

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Skin getUiSkin() {
        return uiSkin;
    }


    public Map<String, Screen> getScreenList() {
        return screenList;
    }

    @Override
    public void create() {

        this.uiSkin = new Skin(Gdx.files.internal("ui/Particle Park UI.json"));
        this.backgroundColor = Color.ROYAL;

        this.screenList = new HashMap<>();
        screenList.put("HomeScreen", new HomeScreen(this));
        screenList.put("LoadScreen", new LoadScreen(this));
        screenList.put("OptionsScreen", new OptionsScreen(this));
        screenList.put("NewGameScreen", new NewGameScreen(this, gameState));

        MainScreen mainScreen = new MainScreen(this, gameState);
        screenList.put("MainScreen", new MainScreen(this, gameState));

        setScreen(screenList.get("HomeScreen"));
    }
}
