import data.DataFile;
import data.DayFile;
import gui.GuiMain;

import java.io.IOException;

public class Main
{
    private static GuiMain guiMain;
    public static DataFile dataFile;
    public static DayFile dayFile;
    public static void main(String[] args)
    {
        /*
        * Main function of the program, instantiated variables and reads data from files.
        * */
        dataFile = new DataFile();
        dayFile = new DayFile();
        guiMain = new GuiMain(dataFile, dayFile);
        guiMain.main();
        guiMain.refreshGlobal(dataFile.loadDataString(), dataFile.loadData());
        guiMain.updateGUI();
        try {
            dataFile.saveData(guiMain.currentData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        guiMain.refreshGlobal(dataFile.loadDataString(), dataFile.loadData());
        guiMain.updateGUI();

    }

}