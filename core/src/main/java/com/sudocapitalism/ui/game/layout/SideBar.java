package com.sudocapitalism.ui.game.layout;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextTooltip;
import com.badlogic.gdx.scenes.scene2d.ui.TooltipManager;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.sudocapitalism.Main;
import com.sudocapitalism.gameState.GameState;


/**
 * Represents the sidebar of the game UI.
 * This class orchestrates the layout and interaction of the sidebar buttons used to navigate
 * between different dashboard views (Employees, Market, Production) and advance time.
 * It encapsulates the creation of TextButton instances with tooltips and delegates
 * view switching logic to {@link MainScreenLayout} or game progression to {@link GameState}.
 *
 * @author Elmouu
 */
public class SideBar extends Table {

    // ---< Attributes >---

    /** The main game instance used to retrieve the UI skin. */
    private final Main main;

    /** Manager that handle the tooltip display logic. */
    private final TooltipManager tooltipManager;


    // ---< Constructor >---

    /**
     * Default constructor that initializes a SideBar.
     * It instantiates the tooltip manager, and then builds the navigation buttons followed by the Next Week button.
     */
    public SideBar(Main main, GameState gameState, MainScreenLayout mainScreenLayout) {

        this.defaults().width(50f);

        this.main = main;

        this.setBackground(this.main.getUiSkin().getDrawable("textfield"));

        this.tooltipManager = new TooltipManager();
        this.tooltipManager.instant();

        this.add(this.employeesDashboardButton(mainScreenLayout)).top().row();
        this.add(this.marketDashboardButton(mainScreenLayout)).row();
        this.add(this.productionDashboardButton(mainScreenLayout)).row();

        this.add(this.nextWeekButton(gameState)).bottom();
    }


    // ----------< Employees >----------

    /**
     * Creates the button to navigate to the employee's dashboard.
     */
    private TextButton employeesDashboardButton(MainScreenLayout mainScreenLayout)  {

        TextButton employeesDashboardButton = new TextButton("E", this.main.getUiSkin());

        employeesDashboardButton.addListener(
            new TextTooltip("Manage employees", this.tooltipManager, this.main.getUiSkin())
        );

        employeesDashboardButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mainScreenLayout.hideProduction();
            }
        });

        return  employeesDashboardButton;
    }


    // ----------< Market >----------

    /**
     * Creates the button to navigate to the market's dashboard.
     */
    private TextButton marketDashboardButton(MainScreenLayout mainScreenLayout)  {

        TextButton marketDashboardButton = new TextButton("M", this.main.getUiSkin());

        marketDashboardButton.addListener(
            new TextTooltip("Manage the market", this.tooltipManager, this.main.getUiSkin())
        );

        marketDashboardButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mainScreenLayout.hideProduction();
            }
        });

        return marketDashboardButton;
    }


    // ----------< Production >----------

    /**
     * Creates the button to navigate to the production dashboard.
     */
    private TextButton productionDashboardButton(MainScreenLayout mainScreenLayout)  {

        TextButton productionDashboardButton = new TextButton("P", this.main.getUiSkin());

        productionDashboardButton.addListener(
            new TextTooltip("Manage the production", this.tooltipManager, this.main.getUiSkin())
        );

        productionDashboardButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                mainScreenLayout.showProductionDashboard();
            }
        });

        return productionDashboardButton;
    }


    // ----------< Time >----------

    /**
     * Creates the button to advance the game time.
     * Triggers {@link GameState#nextWeek()} when clicked.
     */
    private TextButton nextWeekButton(GameState gameState) {

        TextButton nextWeekButton = new TextButton(">>", this.main.getUiSkin());

        nextWeekButton.addListener(
            new TextTooltip("Start the next week", this.tooltipManager, this.main.getUiSkin())
        );

        nextWeekButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameState.nextWeek();
            }
        });

        return nextWeekButton;
    }
}
