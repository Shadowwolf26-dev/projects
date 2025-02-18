package util;

import java.awt.*;

public class Bar
{
    /*
    * Bar method that stores all the values necessary
    * for a Bar in the BarChart object
    * */
    private Color color;
    private int value;

    public Bar(Color color, int value)
    {
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
