package com.sudocapitalism.ui.game.layout;

import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.ui.game.dashboards.ProductionDashboard;

public class MainScreenLayout extends Table {

    public MainScreenLayout(Main main, GameState gameState) {

        this.setFillParent(true);
        this.defaults().expandX();

        // ---< Top bar of the screen >---

        TopBar topBar = new TopBar(main, gameState);
        this.add(topBar).pad(10f, 0, 10f, 0).row();


        // ---< Center part of the screen >---

        SideBar buttonGroup = new SideBar(main, gameState);

        Table dashboard = new ProductionDashboard(main, gameState);

        ScrollPane scrollPane = new ScrollPane(dashboard);

        Table window = new Table();
        window.setDebug(true);
        window.add(buttonGroup).expandY().fillY().padRight(5f);
        window.add(scrollPane).expand().fill().padLeft(5f);


        this.add(window).expand().fill().pad(0, 10f, 10f, 10f);
    }
}
