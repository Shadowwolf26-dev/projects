package gui;

import data.DataFile;
import data.DayFile;
import util.Data;
import util.InstructionEvent;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GuiMain
{
    //Instantiates Objects
    private Events events;
    private DayFile dayFile;

    //Instantiates Data
    public Map<String, Integer> globalMap = new HashMap<>();
    public Data currentData;

    //Instantiates GUI Objects
    private JFrame frame;
    public JLabel text;
    public JLabel day;
    public JPanel buttonPanel;
    private BarChart barChart = new BarChart();

    //Instantiates MISC
    public int dayNumber;
    private final ValueUpdateSystem valueUpdateSystem = new ValueUpdateSystem(this);

    public GuiMain(DataFile dataFile, DayFile dayFile)
    {
        //Constructor for GUIMain, instantiates basic variables
        events = new Events(this, dataFile);

        dayNumber = dayFile.loadFile();

        this.dayFile = dayFile;

        globalMap.put("population", 75);
        globalMap.put("education", 25);
        globalMap.put("research", 0);
        globalMap.put("hdi", 50);
        globalMap.put("co2", 50);
        globalMap.put("poverty", 5);
        globalMap.put("accessibility", 25);
        globalMap.put("tax", 15);
        globalMap.put("crime", 5);
        globalMap.put("po", 50);
        globalMap.put("happiness", 50);
        globalMap.put("gdp", 50);
        currentData = new Data(75, 25, 0, 50, 5, 25, 15, 5 ,50 ,50 ,50, 50);
    }
    public void main()
    {
        /*
        * Main function for the GUI.
        * Instantiates the Frame, Buttons and Text that is on the screen
        * Also instantiates the Bar Graph.
        * */
        frame = new JFrame("Climate Change Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920,1080);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.setSize(400, 400);

        populateBarChart();
        barChart.setSize(400, 1000);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 2));

        JButton rButton1 = new JButton("Build Schools! (+5 Education)");
        buttonPanel.add(rButton1);
        rButton1.addActionListener(events);

        JButton rButton2 = new JButton("Invest in Research (+2 Research)");
        buttonPanel.add(rButton2);
        rButton2.addActionListener(events);

        JButton rButton3 = new JButton("Increase Green Energy Spending. (-10 CO2)");
        buttonPanel.add(rButton3);
        rButton3.addActionListener(events);

        JButton rButton4 = new JButton("Create Jobs and Build Shelters. (-1 Poverty)");
        buttonPanel.add(rButton4);
        rButton4.addActionListener(events);

        JButton rButton5 = new JButton("Equity Spending (+10 Accessibility)");
        buttonPanel.add(rButton5);
        rButton5.addActionListener(events);

        JButton lButton1 = new JButton("Lower Tax Rate (-2 Tax Rate)");
        buttonPanel.add(lButton1);
        lButton1.addActionListener(events);

        JButton lButton2 = new JButton("Increase Security. (-5 Crime Rate)");
        buttonPanel.add(lButton2);
        lButton2.addActionListener(events);

        JButton lButton3 = new JButton("Post a Meme (+1 PO)");
        buttonPanel.add(lButton3);
        lButton3.addActionListener(events);

        JButton lButton4 = new JButton("Build Factory (+5 GDP)");
        buttonPanel.add(lButton4);
        lButton4.addActionListener(events);

        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);

        panel.add(BorderLayout.CENTER, barChart);
        JPanel tPanel = new JPanel();
        tPanel.setSize(450, 75);
        frame.getContentPane().add(BorderLayout.NORTH, tPanel);

        text = new JLabel("Welcome to Climate Change Simulator!");
        text.setFont(new Font("Serif", Font.PLAIN, 24));

        day = new JLabel("Day: " + dayNumber);
        day.setFont(new Font("Serif", Font.PLAIN, 24));

        tPanel.setLayout(new GridLayout(2, 1));
        tPanel.add(BorderLayout.NORTH, text);
        tPanel.add(BorderLayout.SOUTH, day);

        frame.add(BorderLayout.NORTH, tPanel);
        frame.add(BorderLayout.CENTER, panel);
        frame.setVisible(true);


        //Instantiates instruction thread. Multithreading the instructions.
        InstructionEvent instructionEvent = new InstructionEvent(text);
        instructionEvent.start();
    }

    public void updateBarChart(Map<String, Integer> updateMap)
    {
        /*
        * Function for updating bar chart.
        * Uses a function in valueUpdateSystem to update all values.
        * Finishes by saving the current day the program is on.
        * */
        for (Map.Entry<String, Integer> entry : updateMap.entrySet())
        {
            valueUpdateSystem.updateAllValues(entry.getKey());
        }
        dayNumber += 1;

        dayFile.saveFile(dayNumber);

        day.setText("Day: " + dayNumber);
        System.out.println(currentData.dataMap);
    }

    private void populateBarChart()
    {
        /*
        * Populates the bar graph by clamping it at a max 100 and min 0
        * Updates the bars with the name of the entry in the globalMap
        * */
        for (Map.Entry<String, Integer> entry : globalMap.entrySet())
        {
            int num = entry.getValue();

            if (num >= 100)
                num = 100;
            else if (num <= 0)
                num = 0;

            System.out.println("[DEBUG] " + entry.getKey() + " " + entry.getValue());
            barChart.updateBar(entry.getKey(), Color.CYAN, num);
        }
    }

    public void updateGUI()
    {
        /*
        * Populates bar chart, repaints the frame
        * updates currentData variable
        * */
        populateBarChart();
        frame.repaint();

        currentData = new Data(globalMap);

    }

    public void refreshGlobal(Map<String, Integer> changeMap, Map<Data.Type, Integer> changeMapEnum)
    {
        //Refreshes globalMap and currentData variables
        globalMap.putAll(changeMap);
        currentData.dataMap.putAll(changeMapEnum);
    }
}
