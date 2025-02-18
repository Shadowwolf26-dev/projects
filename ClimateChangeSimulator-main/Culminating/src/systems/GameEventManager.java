package systems;

import gui.GuiMain;
import util.Data;
import util.EndEvent;

import java.io.File;
import java.util.Map;
import java.util.Random;

public class GameEventManager
{
    private GuiMain guiMain;
    private boolean dead;

    public GameEventManager(GuiMain guiMain)
    {
        //Constructor gor GameEventManager; Manages Game Events
        this.guiMain = guiMain;
        dead = false;
    }

    public Map<Data.Type, Integer> nextDay()
    {
        /*
        * Checks all values and adjusts other values if an event has occured
        * (Ex: OverPopulation, Regicide)
        * Ends the program if a Death Event is Reached
        * */
        Map<Data.Type, Integer> dataMap = guiMain.currentData.dataMap;


        if (dataMap.get(Data.Type.HDI) > 50)
        {
            guiMain.text.setText("The UN recognizes your awesomeness!");
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) + 10);
        }
        if (dataMap.get(Data.Type.PUBLIC_OPINION) > 75)
        {
            guiMain.text.setText("Your citizens have built a statue of you!");
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) + 10);
            dataMap.put(Data.Type.HDI, dataMap.get(Data.Type.HDI) + 2);

        }
        if (dataMap.get(Data.Type.HAPPINESS) > 90)
        {
            guiMain.text.setText("Your subjects recognize your awesomeness!");
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) + 10);
        }
        if (dataMap.get(Data.Type.EDUCATION) > 90)
        {
            guiMain.text.setText("Brain size is doubling!");
            dataMap.put(Data.Type.RESEARCH, dataMap.get(Data.Type.RESEARCH) + 1);
            dataMap.put(Data.Type.EDUCATION, dataMap.get(Data.Type.EDUCATION) - 1);

        }
        if (dataMap.get(Data.Type.RESEARCH) > 50)
        {
            guiMain.text.setText("The Human Species is Advancing!");
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) + 5);
            dataMap.put(Data.Type.POVERTY, dataMap.get(Data.Type.POVERTY) - 5);
            dataMap.put(Data.Type.CO2, dataMap.get(Data.Type.CO2) - 5);
            dataMap.put(Data.Type.RESEARCH, dataMap.get(Data.Type.RESEARCH) - 3);

        }
        if (dataMap.get(Data.Type.CRIME_RATE) > 20)
        {
            guiMain.text.setText("Officer, I just wanted to decapitate that man!");
            dataMap.put(Data.Type.HDI, dataMap.get(Data.Type.HDI) - 5);
        }
        if (dataMap.get(Data.Type.POPULATION) >= 95)
        {
            guiMain.text.setText("Overpopulation!");
            dataMap.put(Data.Type.ACCESSIBILITY, dataMap.get(Data.Type.ACCESSIBILITY) - 10);
            dataMap.put(Data.Type.POVERTY, dataMap.get(Data.Type.POVERTY) + 5);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 10);
            dataMap.put(Data.Type.POPULATION, dataMap.get(Data.Type.POPULATION) - 5);
            dataMap.put(Data.Type.CRIME_RATE, dataMap.get(Data.Type.CRIME_RATE) + 10);
        }
        if (dataMap.get(Data.Type.POVERTY) >= 50)
        {
            guiMain.text.setText("Why are there so many people on the streets?!");
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) - 20);
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 50);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 50);
            dataMap.put(Data.Type.HDI, dataMap.get(Data.Type.HDI) - 10);
            dataMap.put(Data.Type.EDUCATION, dataMap.get(Data.Type.EDUCATION) - 10);
        }

        if (dataMap.get(Data.Type.TAX_RATE) >= 75)
        {
            guiMain.text.setText("Angry conservative noises!");
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 10);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 20);
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) - 10);

        }
        if (dataMap.get(Data.Type.CRIME_RATE) >= 50)
        {
            guiMain.text.setText("Everyone's been robbed!");
            dataMap.put(Data.Type.EDUCATION, dataMap.get(Data.Type.EDUCATION) - 10);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 50);
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 50);
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) - 10);
            dataMap.put(Data.Type.HDI, dataMap.get(Data.Type.HDI) - 10);

        }
        if (dataMap.get(Data.Type.TAX_RATE) < 1)
        {
            guiMain.text.setText("Bankruptcy!!");
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) - 10);
        }
        if (dataMap.get(Data.Type.GDP) < 10)
        {
            guiMain.text.setText("You are poor!");
            dataMap.put(Data.Type.TAX_RATE, dataMap.get(Data.Type.TAX_RATE) + 5);
            dataMap.put(Data.Type.POVERTY, dataMap.get(Data.Type.POVERTY) + 5);
            dataMap.put(Data.Type.ACCESSIBILITY, dataMap.get(Data.Type.ACCESSIBILITY) - 10);
        }
        if (dataMap.get(Data.Type.EDUCATION) < 20)
        {
            guiMain.text.setText("Stop posting memes in class!");
            dataMap.put(Data.Type.GDP, dataMap.get(Data.Type.GDP) - 5);
            dataMap.put(Data.Type.POVERTY, dataMap.get(Data.Type.POVERTY) + 5);
            dataMap.put(Data.Type.CRIME_RATE, dataMap.get(Data.Type.CRIME_RATE) + 10);
        }
        if (dataMap.get(Data.Type.CO2) >= 70)
        {
            guiMain.text.setText("The air tastes funny!");
            dataMap.put(Data.Type.POVERTY, dataMap.get(Data.Type.POVERTY) + 5);
            dataMap.put(Data.Type.PUBLIC_OPINION, dataMap.get(Data.Type.PUBLIC_OPINION) - 10);
            dataMap.put(Data.Type.HAPPINESS, dataMap.get(Data.Type.HAPPINESS) - 5);
            dataMap.put(Data.Type.POPULATION, dataMap.get(Data.Type.POPULATION) - 10);

        }

        //Death Events Below, both death events remove the buttons to prevent the user from continuing to input data
        if (dataMap.get(Data.Type.POPULATION) <= 20)
        {
            System.out.println("Death Event");
            guiMain.text.setText("You have Died!");
            dead = true;
            guiMain.buttonPanel.setVisible(false);

            //DEATH EVENT
        }
        if (dataMap.get(Data.Type.PUBLIC_OPINION) <= 10)
        {
            System.out.println("Death Event");
            guiMain.text.setText("Regicide!");
            dead = true;
            guiMain.buttonPanel.setVisible(false);

            //DEATH EVENT
        }

        //Starts a thread to end the program

        EndEvent endEvent = new EndEvent(dead);
        endEvent.start();

        return dataMap;
    }

    public boolean isDead()
    {
        return dead;
    }
}
