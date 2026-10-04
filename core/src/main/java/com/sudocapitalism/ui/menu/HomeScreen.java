package com.sudocapitalism.ui.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.sudocapitalism.Main;


/**
 * The main entry point for the game, displaying a menu with options to start playing, access settings, or exit the application.
 * This screen handles input routing via a Stage and manages transitions between different game screens.
 *
 * @author Elmouu
 */
public class HomeScreen implements Screen {

    // The main shared between all screens
    private final Main main;

    private Stage stage;

    /**
     * Constructs a new {@code HomeScreen} with the provided {@link Main} instance.
     * The screen will be initialized when {@link #show()} is called.
     *
     * @param main the main game controller used to switch screens and access shared resources.
     */
    public HomeScreen(Main main) {
        this.main = main;
    }

    /**
     * Initializes the screen: creates a Stage with a full-screen viewport, sets up the input processor,
     * and builds a menu table containing three buttons (Start, Options, Exit). Each button is wired
     * to navigate to its respective target screen or terminate the application.
     */
    @Override
    public void show() {

        // ---< Setup >---

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        Table root = new Table();
        root.setFillParent(true);
        root.setDebug(false);


        // ---< Buttons >---

        Button startButton = new TextButton("Start", main.uiSkin);
        startButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(main.getScreenList().get("LoadScreen"));
            }
        });

        Button optionsButton = new TextButton("options", main.uiSkin);
        optionsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                main.setScreen(main.getScreenList().get("OptionsScreen"));
            }
        });

        Button exitButton = new TextButton("Exit", main.uiSkin);
        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });


        // ---< Filling the table >---

        root.defaults().width(100f).padBottom(10f);     // Default width & padding for each button

        root.add(startButton).row();
        root.add(optionsButton).row();
        root.add(exitButton);

        stage.addActor(root);
    }

    /**
     * Renders the screen. Clears the viewport with the game's background color and updates/draws the Stage.
     */
    @Override
    public void render(float delta) {

        ScreenUtils.clear(main.getBackgroundColor());

        stage.act(delta);
        stage.draw();
    }

    /**
     * Adjusts the viewport size when the device is resized, ensuring the UI remains properly scaled.
     */
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

    /**
     * Releases resources associated with this screen, primarily disposing of the Stage to prevent memory leaks.
     */
    @Override
    public void dispose() {
        stage.dispose();
    }
}
