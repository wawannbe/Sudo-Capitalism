package com.sudocapitalism.gameState.production;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.sudocapitalism.item.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents a Product that can be produced in a Production and sold by a Company.
 *
 * @author Elmouu
 */
public class Product extends Item {

    // ---------< Attributes >---------

    /** The price to sell the product at */
    private double price;


    // ---------< Constructor >---------

    /**
     * Creates a new instance of a product
     *
     * @param name The name to give to the product
     * @param description Its description
     * @param price Its price
     */
    public Product(String name, String description, double price) {
        super(name, description);
        this.price = price;
    }


    // ---------< Price >---------

    /**
     * Returns the price of the product
     *
     * @return A double representing the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Changes the price to a given value
     *
     * @param price The value to set the price to
     */
    public void setPrice(double price) {
        this.price = price;
    }


    // ---------< Initialization >---------

    /**
     * Initializes the list of available products in the game
     *
     * @return An ArrayList containing the products
     */
    public static List<Product> init() {

        List<Product> products = new ArrayList<>();

        Scanner scanner = new Scanner(Gdx.files.internal("data/products/products.csv").readString());

        while (scanner.hasNext()) {

            String[] line = scanner.nextLine().split(":");

            products.add(new Product(line[0], line[1], Double.parseDouble(line[2])));
        }

        return products;
    }
}
