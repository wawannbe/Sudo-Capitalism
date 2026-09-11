package com.sudocapitalism;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {

    Texture logo;

    SpriteBatch spriteBatch;
    FitViewport viewport;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(5, 5);

        logo = new Texture("libgdx.png");
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true); // true centers the camera
    }

    @Override
    public void render() {
        input();
        logic();
        draw();

    }

    private void input() {

    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);

        viewport.apply();

        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);

        spriteBatch.begin();

        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        spriteBatch.draw(logo, 1, 2, 3, 1);

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
