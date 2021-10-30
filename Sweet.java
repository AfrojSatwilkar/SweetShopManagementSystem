package com.bridglabz.sweetshop;

import java.util.Objects;

public class Sweet {
    enum Color{
        RED_WHITE, WHITE, GREEN_WHITE, YELLOW;
    }

    enum Category{
        MILK, SUGERLESS, GHEE, BENGALISWEET, SUGER;
    }
    enum PropertyType{
        IsDiet, IsNormal;
    }

    Color color;
    int price;
    String id;
    Category category;
    String name;
    PropertyType propertyType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweet sweet = (Sweet) o;
        return id.equals(sweet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "color=" + color +
                ", price=" + price +
                ", id='" + id + '\'' +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", propertyType='" + propertyType +
                '}';
    }
}
