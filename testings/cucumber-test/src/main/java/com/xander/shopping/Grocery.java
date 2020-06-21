package com.xander.shopping;

import java.util.Objects;

/**
 * @author Kevin Azangue
 */
public class Grocery {

    private String name;
    private Price price;

    public Grocery(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public Grocery(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Grocery)) {
            return false;
        }
        Grocery grocery = (Grocery) o;
        return Objects.equals(name, grocery.name) &&
                Objects.equals(price, grocery.price);
    }

    public int hashCode() {
        return Objects.hash(name, price);
    }
}
