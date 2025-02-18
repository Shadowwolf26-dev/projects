package util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data
{
    /*
    * Data class that contains an ENUM and
    * serializes data into a map (dataMap).
    * Transfer strings into ENUM format
    * */
    public Map<Type, Integer> dataMap = new HashMap<>();

    public Data(int population, int education, int research, int co2, int poverty, int accessibility, int taxRate,
                int crimeRate, int publicOpinion, int GDP, int hdi, int happiness)
    {
        dataMap.put(Type.EDUCATION, education);
        dataMap.put(Type.RESEARCH, research);
        dataMap.put(Type.CO2, co2);
        dataMap.put(Type.POVERTY, poverty);
        dataMap.put(Type.ACCESSIBILITY, accessibility);
        dataMap.put(Type.TAX_RATE, taxRate);
        dataMap.put(Type.CRIME_RATE, crimeRate);
        dataMap.put(Type.PUBLIC_OPINION, publicOpinion);
        dataMap.put(Type.GDP, GDP);
        dataMap.put(Type.HDI, hdi);
        dataMap.put(Type.HAPPINESS, happiness);
        dataMap.put(Type.POPULATION, population);
    }


    public Data(Collection<Integer> dl)
    {
        if (dl.size() < 11)
            return;

        List<Integer> dataList = dl.stream().toList();
        System.out.println(dataList);
        dataMap.put(Type.EDUCATION, dataList.get(0));
        dataMap.put(Type.RESEARCH, dataList.get(1));
        dataMap.put(Type.CO2, dataList.get(2));
        dataMap.put(Type.POVERTY, dataList.get(3));
        dataMap.put(Type.ACCESSIBILITY, dataList.get(4));
        dataMap.put(Type.TAX_RATE, dataList.get(5));
        dataMap.put(Type.CRIME_RATE, dataList.get(6));
        dataMap.put(Type.PUBLIC_OPINION, dataList.get(7));
        dataMap.put(Type.GDP, dataList.get(8));
        dataMap.put(Type.HDI, dataList.get(9));
        dataMap.put(Type.HAPPINESS, dataList.get(10));
        dataMap.put(Type.POPULATION, dataList.get(11));
    }

    public Data(Map<String, Integer> map)
    {
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            switch (entry.getKey())
            {
                case "population" -> dataMap.put(Type.POPULATION, entry.getValue());
                case "education" -> dataMap.put(Type.EDUCATION, entry.getValue());
                case "research" -> dataMap.put(Type.RESEARCH, entry.getValue());
                case "hdi" -> dataMap.put(Type.HDI, entry.getValue());
                case "co2" -> dataMap.put(Type.CO2, entry.getValue());
                case "poverty" -> dataMap.put(Type.POVERTY, entry.getValue());
                case "accessibility" -> dataMap.put(Type.ACCESSIBILITY, entry.getValue());
                case "tax" -> dataMap.put(Type.TAX_RATE, entry.getValue());
                case "crime" -> dataMap.put(Type.CRIME_RATE, entry.getValue());
                case "po" -> dataMap.put(Type.PUBLIC_OPINION, entry.getValue());
                case "happiness" -> dataMap.put(Type.HAPPINESS, entry.getValue());
                case "gdp" -> dataMap.put(Type.GDP, entry.getValue());
            }
        }
    }

    public enum Type
    {
        EDUCATION,
        RESEARCH,
        CO2,
        POVERTY,
        ACCESSIBILITY,
        TAX_RATE,
        CRIME_RATE,
        PUBLIC_OPINION,
        GDP,
        HDI,
        HAPPINESS,
        POPULATION
    }

}
