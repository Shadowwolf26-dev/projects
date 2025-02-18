package gui;

import data.DataFile;
import systems.GameEventManager;
import util.Data;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Events implements java.awt.event.ActionListener
{
    //Instantiates Reference Objects
    private GuiMain guiMain;
    private GameEventManager gameEventManager;
    private DataFile dataFile;

    //Instantiates topics list
    private final String[] topics = {"Education", "Research", "CO2", "Poverty", "Accessibility", "Tax",
            "Crime", "PO", "Population","GDP"};
    public Events(GuiMain guiMain, DataFile dataFile)
    {
        //Constructor for event handler class.

        this.dataFile = dataFile;
        this.guiMain = guiMain;
        gameEventManager = new GameEventManager(guiMain);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //NOTE: THIS FUNCTION IS NOT BLOCK COMMENTED AS IT IS MORE COMPLEX THAN OTHER FUNCTIONS;
        //IT IS INSTEAD COMMENTED LINE BY LINE.
        //Detects when a button is clicked
        String s = e.getActionCommand();
        String topic = "";
        int change = 0;
        boolean negative = false;

        for (String t : topics)
        {
            //Checks the name of the button and sees if it matches the topics
            if (s.contains(t))
            {
                topic = t;

                List<String> strings = List.of(s.split("\\+"));

                if (strings.size() <= 1)
                {
                    strings = List.of(s.split("-"));
                    negative = true;
                }

                strings = List.of(strings.get(1).split(" "));

                change = Integer.parseInt(strings.get(0));
                if (negative)
                    change *= -1;

                //Splits Strings to determine the increase value and updates accordingly
                updateData(topic.toLowerCase(), change);
                break;
            }
        }

        //Creates maps that will be populated with new data
        Map<String, Integer> newChangeMap = new HashMap<>();
        Map<Data.Type, Integer> nextDayMap = gameEventManager.nextDay();
        for (Data.Type type : nextDayMap.keySet())
        {
            //Updates newDataMap(s)
            String name = "";

            switch (type)
            {
                case EDUCATION:
                    name = "education";
                    break;
                case RESEARCH:
                    name = "research";
                    break;
                case CO2:
                    name = "co2";
                    break;
                case POVERTY:
                    name = "poverty";
                    break;
                case ACCESSIBILITY:
                    name = "accessibility";
                    break;
                case TAX_RATE:
                    name = "tax";
                    break;
                case CRIME_RATE:
                    name = "crime";
                    break;
                case PUBLIC_OPINION:
                    name = "po";
                    break;
                case GDP:
                    name = "gdp";
                    break;
                case HDI:
                    name = "hdi";
                    break;
                case HAPPINESS:
                    name = "happiness";
                    break;
                case POPULATION:
                    name = "population";
                    break;
            }

            newChangeMap.put(name, nextDayMap.get(type));
        }
        updateDataMap(newChangeMap, nextDayMap);

        //Save's data if the program has not ended
        if (gameEventManager.isDead())
            return;
        try
        {
            dataFile.saveData(guiMain.currentData);
        }
        catch (IOException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    private void updateData(String topic, int change)
    {
        //Updates a topic and its bar on the gui
        Map<String, Integer> changeMap = new HashMap<>();
        changeMap.put(topic, change);

        guiMain.updateBarChart(changeMap);
        guiMain.updateGUI();

    }

    private void updateDataMap(Map<String, Integer> changeMap, Map<Data.Type, Integer> changeMapEnum)
    {
        //Update the entire dataMap in the guiMain object
        guiMain.refreshGlobal(changeMap, changeMapEnum);
        guiMain.updateGUI();
    }
}
