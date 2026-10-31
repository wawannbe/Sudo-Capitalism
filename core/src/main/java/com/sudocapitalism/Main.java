package com.sudocapitalism;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.company.production.Product;
import com.sudocapitalism.ui.game.MainScreen;
import com.sudocapitalism.ui.menu.HomeScreen;
import com.sudocapitalism.ui.menu.NewGameScreen;
import com.sudocapitalism.ui.menu.OptionsScreen;
import com.sudocapitalism.ui.menu.LoadScreen;

import java.util.*;

/**
 * Main class of the game, manages and instanciates everything
 *
 * @author Elmouu
 */
public class Main extends Game {

    // ---------< Attributes >---------

    // ---< Esthetics >---

    /** The skin used for the graphical interface */
    private Skin uiSkin;

    /** The color of the background used in all the screens of the game */
    private Color backgroundColor;


    // ---< Screens >---

    /** Contains all the screens of the game */
    private Map<String, Screen> screenList;


    // ---< GameState >---

    /** The game state used by all the screens and classes */
    private GameState gameState;


    // ---< Products >---

    /** The list of all the products the company can choose to produce */
    private Map<String, Product> availableToProduce;


    // ---------< Constructor >---------

    /**
     * Initializes LibGDX and the game
     */
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

    /**
     * Returns the currently selected background color
     *
     * @return The background color
     */
    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    /**
     * Sets the background color to the given color, used in the {@link OptionsScreen}
     *
     * @param backgroundColor The color to be applied
     */
    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * Returns the Skin set to be used
     *
     * @return The skin being used
     */
    public Skin getUiSkin() {
        return uiSkin;
    }


    // ---------< Screens >---------

    /**
     * Returns a read-only copy of the screen list
     *
     * @return A map containing all the screens
     */
    public Map<String, Screen> getScreenList() {
        return Collections.unmodifiableMap(this.screenList);
    }


    // ---------< Products >---------

    /**
     * Returns a read-only copy of the list of all the {@link Product} the Company can choose to produce and sell.
     *
     * @return The products as a list
     */
    public Map<String, Product> getAvailableToProduce() {
        return Collections.unmodifiableMap(this.availableToProduce);
    }

    public String[] getAvailableToProduceNames() {

        String[] productsNames = new String[this.availableToProduce.size()];

        int idx = 0;

        for (Map.Entry<String, Product> productEntry : this.availableToProduce.entrySet()) {

            productsNames[idx] = productEntry.getKey();

            idx++;
        }

        return productsNames;
    }

    public Product getProductByName(String name) {
        return this.availableToProduce.get(name);
    }
}
