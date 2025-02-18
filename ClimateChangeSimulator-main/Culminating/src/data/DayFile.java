package data;

import util.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class DayFile
{
    private int dayNumber;

    public DayFile()
    {
        //Constructor for DayFile object
        createFile();
    }

    public void createFile()
    {
        //Creates a File with the name "gameDay.txt"
        try {
            File myObj = new File("gameDay.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void saveFile(int day)
    {
        //Saves int day into a file
        createFile();
        FileWriter writer;
        try {
            writer = new FileWriter("gameDay.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            writer.write(String.valueOf(day));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int loadFile()
    {
        //Loads number from file gameDay.txt
        String dataString = "";
        File file = new File("gameDay.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                dataString = scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int i = 0;
        try
        {
            i = Integer.parseInt(dataString);
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
        return i;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }
}
