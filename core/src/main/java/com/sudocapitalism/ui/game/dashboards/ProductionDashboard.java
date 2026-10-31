package com.sudocapitalism.ui.game.dashboards;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;
import com.sudocapitalism.ui.game.widgets.ProductionWidget;

/**
 * Handles the UI on the production management
 *
 * @author Elmouu
 */
public class ProductionDashboard extends Table {

    // ---------< Attributes >---------

    // ---< Game stuff >---

    /** Main used */
    private final Main main;

    /** GameState used */
    private final GameState gameState;


    // ---< Stage >---

    /** Stage to display the dialog on */
    private final Stage mainScreenStage;


    // ---< Dialog >---

    /** Dialog used to choose which product is gonna be produced */
    private Dialog newProductionDialog;


    // ---< SelectBox >---

    /** SelectBox used to choose the product */
    private SelectBox<String> productsSelection;


    // ---------< Constructor >---------

    /**
     * Creates a new dashboard
     *
     * @param main The main to use
     * @param gameState The game state
     * @param mainScreenStage The main stage to display the dialog
     */
    public ProductionDashboard(Main main, GameState gameState, Stage mainScreenStage) {

        this.main = main;
        this.gameState = gameState;

        this.mainScreenStage = mainScreenStage;

        this.initNewProductionDialog();     // Initializes the whole dialog

        this.initNewProductionButton();     // Initializes the button that triggers the dialog
    }


    // ---------< Initialization >---------

    // ---< Dialog >---

    /**
     * Initializes the Dialog using other initialization methods
     */
    public void initNewProductionDialog() {

        this.newProductionDialog = new Dialog("Launch a new production (500$)", main.getUiSkin());      // Creation of the dialog

        this.addStartButtonToDialog();
        this.addCancelButtonToDialog();

        this.initProductsSelectionBox();
    }

    // ---< SelectBox >---

    /**
     * Initializes the product selection box
     */
    public void initProductsSelectionBox() {

        this.newProductionDialog.getContentTable().add(new Label("What do you want to produce ?", main.getUiSkin())).expandX().pad(4f);    // Label on the side of the box

        this.productsSelection = new SelectBox<>(this.main.getUiSkin());
        productsSelection.setItems(this.main.getAvailableToProduceNames());    // Creates a box with the names of the products that are available

        this.newProductionDialog.getContentTable().add(productsSelection).expandX().fill();
    }

    // ---< Start production button >---

    /**
     * Initializes the start production button
     */
    public void addStartButtonToDialog() {

        Button startButton = new TextButton("Start production !", main.getUiSkin());    // Creates the button

        startButton.addListener(new ChangeListener() {  // On click

            @Override
            public void changed(ChangeEvent event, Actor actor) {

                gameState.getCompany().newProduction(main.getProductByName(productsSelection.getSelected()));   // Creates a new Production

                if ((getChildren().size %2) == 0) {

                    add(new ProductionWidget(main, gameState)).pad(10f).row();

                } else {
                    add(new ProductionWidget(main, gameState)).pad(10f);
                }

                newProductionDialog.hide();                                                                     // Closes the dialog
            }
        });

        this.newProductionDialog.getButtonTable().add(startButton).expandX().fill();
    }

    // ---< Cancel button >---

    /**
     * Initializes the cancel production button
     */
    public void addCancelButtonToDialog() {

        Button cancelButton = new TextButton("Cancel", main.getUiSkin());

        cancelButton.addListener(new ChangeListener() {

            @Override
            public void changed(ChangeEvent event, Actor actor) {
                newProductionDialog.hide();
            }
        });

        this.newProductionDialog.getButtonTable().add(cancelButton).expandX().fill();
    }

    // ---< Open dialog button >---

    /**
     * Initializes the new production button
     */
    public void initNewProductionButton() {

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
