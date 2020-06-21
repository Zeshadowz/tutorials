package com.xander.shopping;

import java.util.Objects;

/**
 * @author Kevin Azangue
 */
public class Price {

    private int value;

    public Price(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Price)) {
            return false;
        }
        Price price = (Price) o;
        return value == price.value;
    }

    public int hashCode() {
        return Objects.hash(value);
    }
}
