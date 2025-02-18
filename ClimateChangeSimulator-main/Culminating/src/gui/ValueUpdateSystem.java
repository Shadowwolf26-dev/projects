package gui;

public class ValueUpdateSystem
{
    //Instantiates static final topic list
    public static final String[] topics = {"education", "research", "co2", "poverty", "accessibility", "tax",
            "crime", "po", "gdp", "population"};

    //Instantiates all variables that need to be used
    public int education, research, co2, poverty, accessibility, taxRate, crimeRate, publicOpinion, GDP, hdi, happiness, population;

    //Reference to GUIMain
    private GuiMain guiMain;

    //Constructor for this object
    public ValueUpdateSystem(GuiMain guiMain)
    {
        this.guiMain = guiMain;
    }

    public void updateAllValues(String s)
    {
        /*
        * Function that updates all variables based on a particular string
        * Values are based on planning (altered for balancing)
        */
        education = 0;
        research = 0;
        co2 = 0;
        poverty = 0;
        accessibility = 0;
        taxRate = 0;
        crimeRate = 0;
        publicOpinion = 0;
        GDP = 0;
        hdi = 0;
        happiness = 0;
        population = 0;
        if (s.equals(topics[0]))
        {
            //Education
            population -= 1;
            education += 5;
            hdi += 5;
            poverty -= 1;
            accessibility += 3;
            taxRate += 5;
            publicOpinion -= 1;
            happiness += 1;
            GDP += 5;
        }
        else if (s.contains(topics[1]))
        {
            //Research
            research += 2;
            education += 5;
            hdi += 5;
            co2 += 1;
            poverty -= 3;
            accessibility += 2;
            taxRate += 2;
            GDP += 5;
        }
        else if (s.contains(topics[2]))
        {
            //Warming
            co2 -= 10;
            poverty -= 1;
            accessibility += 1;
            taxRate += 5;

            GDP -= 5;
        }
        else if (s.contains(topics[3]))
        {
            //Poverty
            hdi += 1;
            poverty -= 1;
            hdi += 5;
            accessibility += 1;
            crimeRate -= 1;
            publicOpinion -= 1;
            happiness += 1;
            taxRate += 1;

            GDP -= 5;
        }
        else if (s.contains(topics[4]))
        {
            //Accessibility
            accessibility += 10;

            population += 5;
            education += 1;
            hdi += 10;
            poverty -= 1;
            taxRate += 1;
            publicOpinion += 5;
            happiness += 1;

            GDP -= 5;
        }
        else if (s.contains(topics[5]))
        {
            //Tax
            taxRate -= 2;

            population += 1;
            poverty -= 1;
            accessibility += 1;
            crimeRate -= 1;
            publicOpinion += 5;
            happiness += 5;

            GDP += 1;
        }
        else if (s.contains(topics[6]))
        {
            //Crime Rate

            crimeRate -= 5;
            population += 1;
            hdi += 1;
            poverty -= 1;
            publicOpinion -= 1;
            happiness += 5;
            taxRate += 3;

        }
        else if (s.contains(topics[7]))
        {
            //Public Opinion

            publicOpinion += 1;
            hdi += 1;
            crimeRate -= 5;
            happiness += 5;
            education -= 1;

            GDP -= 1;
        }
        else if (s.contains(topics[8]))
        {
            //GDP

            GDP += 5;
            education -= 1;
            hdi -= 1;
            co2 += 5;
            poverty -= 5;
            taxRate -= 5;
            accessibility -= 1;

        }

        for (String string : topics)
        {
            int x = 0;
            string = string.toLowerCase();
            if (string.contains("population"))
            {
                x = population;
            }
            if (string.contains("education"))
            {
                x = education;
            }
            else if (string.contains("research"))
            {
                x = research;
            }
            else if (string.contains("co2"))
            {
                x = co2;
            }
            else if (string.contains("poverty"))
            {
                x = poverty;
            }
            else if (string.contains("accessibility"))
            {
                x = accessibility;
            }
            else if (string.contains("tax"))
            {
                x = taxRate;
            }
            else if (string.contains("crime"))
            {
                x = crimeRate;
            }
            else if (string.contains("po"))
            {
                x = publicOpinion;
            }
            else if (string.contains("gdp"))
            {
                x = GDP;
            }

            x += guiMain.globalMap.get(string);

            //Caps values
            if (x >= 100)
                x = 100;
            else if (x <= 0)
                x = 0;

            //Updates Global Map
            guiMain.globalMap.put(string.toLowerCase(), x);
        }
    }
}
