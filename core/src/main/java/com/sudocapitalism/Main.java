package com.sudocapitalism;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {

    public Texture logo;

    public SpriteBatch spriteBatch;

    public Sprite textureSprite;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        logo = new Texture("libgdx.png");

        textureSprite = new Sprite(logo);
        textureSprite.setBounds(0, 0, 200, 200);
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.CLEAR);

        spriteBatch.begin();

        textureSprite.draw(spriteBatch);

        spriteBatch.end();
    }

    @Override
    public void dispose() {
        logo.dispose();
        spriteBatch.dispose();
    }

    @Override
    public void resize(int width, int height) {
        spriteBatch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);
    }
}
