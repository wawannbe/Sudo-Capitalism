package com.sudocapitalism.ui.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Array;

/**
 * A wrapper enum providing named access to standard GDX {@link Color} values.
 * It avoids displaying the color in numbers to the user.
 * Only colors that looks good with the game's interface are added in here.
 *
 * @author Elmouu
 */
public enum ColorWrapper {

    OLIVE("Olive", Color.OLIVE),
    SLATE("Slate", Color.SLATE),
    ROYAL("Royal", Color.ROYAL),
    PURPLE("Purple", Color.PURPLE),
    BLACK("Black", Color.BLACK);

    private final String name;
    private final Color color;

    /**
     * Constructs a {@code ColorWrapper} with the given display name and GDX color.
     *
     * @param name The human-readable name of this color.
     * @param color The corresponding {@link Color}.
     */
    ColorWrapper(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    /**
     * Returns the display name of this color wrapper.
     *
     * @return The string name (e.g., "Slate").
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves a {@link Color} by its name using the enum constant.
     *
     * @param name The name of the color to retrieve.
     * @return The corresponding GDX {@link Color}.
     */
    public static Color getColor(String name) {
        return valueOf(name).color;
    }

    /**
     * Returns all the colors in a String[] to be added in the SelectBox
     *
     * @return String[] All the colors names.
     */
    public static String[] getColorsList() {

        String[] colors = new String[ColorWrapper.values().length];

        for (int idx = 0; idx < colors.length; idx ++) {
            colors[idx] = ColorWrapper.values()[idx].getName();
        }

        return colors;
    }
}
