package com.sudocapitalism.gameState.production;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.sudocapitalism.item.Item;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Product extends Item {

    private double price;

    public Product(String name, String description, double price) {
        super(name, description);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

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
