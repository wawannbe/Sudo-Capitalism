package com.sudocapitalism;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.sudocapitalism.ui.MainScreen;
import com.sudocapitalism.ui.OptionsScreen;
import com.sudocapitalism.ui.SaveLoadScreen;
import java.util.ArrayList;

public class Main extends Game {

    private ArrayList<Screen> screenList;

    public ArrayList<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(ArrayList<Screen> screenList) {
        this.screenList = screenList;
    }

    @Override
    public void create() {

        this.screenList = new ArrayList<>();
        screenList.add(new MainScreen(this));
        screenList.add(new SaveLoadScreen(this));
        screenList.add(new OptionsScreen(this));

        setScreen(screenList.getFirst());
    }
}
