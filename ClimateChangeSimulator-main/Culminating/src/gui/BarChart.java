package gui;

import util.Bar;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class BarChart extends JPanel
{
    private Map<String, Bar> bars = new HashMap<>();

    public void addBar(String name, Color color, int value)
    {
        //Function for adding a bar to the bar chart
        Bar bar = new Bar(color, value);
        bars.put(name, bar);
        repaint();
    }

    public void updateBar(String name, Color color, int value)
    {
        //Updates a Bar with a colour and value
        Bar bar = new Bar(color, value);
        bars.put(name, bar);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        /*
        * An extension of the parent object 'paintComponent'
        * Draws the bars with a width based on the screen length / # of bars
        * sets the height of the bars by value / max
        * sets the position of the labels by several constants (width * 0.5) - (graph.length() * 2.75)
        * Draws a rectangle as the bar
        *
        * */
        int max = Integer.MIN_VALUE;
       for (Bar entry : bars.values())
       {
           max = Math.max(max, entry.getValue());
       }

       int width = (getWidth() / bars.size());
       int x = 1;
       for (String graph : bars.keySet())
       {
           Bar entry = bars.get(graph);
           int value = entry.getValue();
           int height = (int) ((getHeight() - 5) * ((double) value / max));
           g.setColor(entry.getColor());
           g.fillRect(x, getHeight() - height, width, height);
           g.setColor(Color.BLACK);
           String s = String.valueOf(value);
           int labelPos = (int) ((x + (width * 0.5) - (graph.length()) * 2.75));
           g.drawString(graph, labelPos, (int) (getHeight() - (height * 0.75)));
           g.drawString(s, (int) (x + (width * 0.5)) - (s.length() * 4), (int) (getHeight() - (height * 0.5)));
           g.drawRect(x, getHeight() - height, width, height);
           x += (width + 2);
       }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(bars.size() * 10 + 2, 50);
    }
}
