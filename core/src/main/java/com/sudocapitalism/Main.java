package com.sudocapitalism;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.gameState.production.Product;
import com.sudocapitalism.ui.game.MainScreen;
import com.sudocapitalism.ui.menu.HomeScreen;
import com.sudocapitalism.ui.menu.NewGameScreen;
import com.sudocapitalism.ui.menu.OptionsScreen;
import com.sudocapitalism.ui.menu.LoadScreen;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main extends Game {

    // ---------< Attributes >---------

    // ---< Esthetics >---

    private Skin uiSkin;
    private Color backgroundColor;


    // ---< Screens >---

    private Map<String, Screen> screenList;


    // ---< GameState >---

    private GameState gameState;


    // ---< Products >---

    /** The list of all the products the company can choose to produce */
    private List<Product> availableToProduce;


    // ---------< Constructor >---------

    @Override
    public void create() {

        this.availableToProduce = Product.init();

        this.gameState = new GameState(this);

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


    // ---------< Esthetics >---------

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Skin getUiSkin() {
        return uiSkin;
    }


    // ---------< Screens >---------

    public Map<String, Screen> getScreenList() {
        return screenList;
    }


    // ---------< Products >---------

    /**
     * Returns a read-only copy of the list of all the {@link Product} the Company can choose to produce and sell.
     *
     * @return The products as a list
     */
    public List<Product> getAvailableToProduce() {
        return Collections.unmodifiableList(this.availableToProduce);
    }
}
