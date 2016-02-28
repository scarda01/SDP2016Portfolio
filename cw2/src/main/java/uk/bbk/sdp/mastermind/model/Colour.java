package uk.bbk.sdp.mastermind.model;

import lombok.Getter;

public class Colour {

    public static final String BLACK = "Black";

    private @Getter String name;

    public Colour(String name) {
        this.name = name;
    }

    public String getUPInitial() {
        return name.substring(0,1).toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Colour colour = (Colour) o;

        return !(name != null ? !name.equals(colour.name) : colour.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
