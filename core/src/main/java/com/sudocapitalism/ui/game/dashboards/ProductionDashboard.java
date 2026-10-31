package com.sudocapitalism.ui.game.dashboards;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.ui.game.widgets.ProductionWidget;

public class ProductionDashboard extends Table {

    private final Dialog newProductionDialog;

    public ProductionDashboard(Main main, GameState gameState, Stage mainScreenStage) {

        this.setDebug(false);

        SelectBox<String> productsSelection = new SelectBox<>(main.getUiSkin());
        productsSelection.setItems(main.getAvailableToProduceNames());

        this.newProductionDialog = new Dialog("Launch a new production (500$)", main.getUiSkin());

        Button startButton = new TextButton("Start production !", main.getUiSkin());

        startButton.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {

                gameState.getCompany().newProduction(main.getProductByName(productsSelection.getSelected()));

                add(new ProductionWidget(main, gameState)).padBottom(10f).row();

                newProductionDialog.hide();
            }
        });

        Button cancelButton = new TextButton("Cancel", main.getUiSkin());

        cancelButton.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                newProductionDialog.hide();
            }
        });


        this.newProductionDialog.getButtonTable().add(cancelButton).expandX().fill();
        this.newProductionDialog.getButtonTable().add(startButton).expandX().fill();


        this.newProductionDialog.getContentTable().add(new Label("What do you want to produce ?", main.getUiSkin())).expandX().pad(4f);
        this.newProductionDialog.getContentTable().add(productsSelection).expandX().fill();


        Button newProductionButton = new TextButton("Buy a new production", main.getUiSkin());

        newProductionButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                newProductionDialog.show(mainScreenStage);
            }
        });

        this.add(newProductionButton).row();
    }
}
