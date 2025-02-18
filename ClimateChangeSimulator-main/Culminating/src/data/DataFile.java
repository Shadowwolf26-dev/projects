package data;

import util.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DataFile
{
    private Data data;

    public DataFile()
    {
        //Constructor for DataFile Object
        createFile();
    }

    public void createFile()
    {
        //Function that creates a file by the nane 'gameData.txt'
        try {
            File myObj = new File("gameData.txt");
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

    public void saveData(Data data) throws IOException
    {
        /*
        * Function to save data. Throws IOException.
        * Gets the file by the pathname of gameData.txt
        * Recreates the file.
        * Writes the Data in the Data object into the file.
        * */
        File f = new File("gameData.txt");
        createFile();
        FileWriter writer;
        try {
            writer = new FileWriter("gameData.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Map.Entry<Data.Type, Integer> entry : data.dataMap.entrySet())
        {
            String write = "";
            write = String.valueOf(entry.getKey());

            write = write + " " + entry.getValue().toString() + " !!";

            try {
                writer.write(write);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        writer.close();
    }

    public Map<String, Integer> loadDataString()
    {
        /*
        * Loads all the data in the file gameData.txt
        * into a Map<String, Integer> to allow for easier and faster refreshing of variables.
        * */
        Map<Data.Type, Integer> baseMap = loadData();
        Map<String, Integer> returnMap = new HashMap<>();
        for (Data.Type type : baseMap.keySet())
        {
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

            returnMap.put(name, baseMap.get(type));
        }
        return returnMap;
    }
    public Map<Data.Type, Integer> loadData()
    {
        /*
        * Loads all data in the gameData.txt into a Map<Data.Type, Integer>
        * */
        String dataString = "";
        File file = new File("gameData.txt");
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

        List<String> splitOne = List.of(dataString.split("!!"));
        Map<Data.Type, Integer> dataMap = new HashMap<>();
        for (String s : splitOne)
        {
            for (Data.Type type : Data.Type.values())
            {
                if (s.toUpperCase().contains(type.toString()))
                {
                    List<String> splitTwo = List.of(s.split(" "));
                    int i = Integer.parseInt(splitTwo.get(1));
                    dataMap.put(type, i);
                }
            }
        }
        System.out.println(dataMap);
        return dataMap;
    }

    //Getter Setter for Data
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
