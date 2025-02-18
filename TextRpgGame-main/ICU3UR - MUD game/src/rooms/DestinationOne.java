package rooms;

import com.sun.tools.javac.Main;
import jdk.jshell.execution.Util;
import utils.Colours;
import utils.GameManager;
import utils.RoomMaker;
import utils.Utils;

public class DestinationOne
{
    GameManager gameManager = new GameManager();
    public void main(RoomMaker roomMaker, int debugMode)
    {
        Utils.clearScreen();

        System.out.print(Colours.RESET + " _____ _             _            _    ______ _ _           \n" +
                "/  ___| |           | |          | |   |  ___(_) |          \n" +
                "\\ `--.| |_ _   _  __| | ___ _ __ | |_  | |_   _| | ___  ___ \n" +
                " `--. \\ __| | | |/ _` |/ _ \\ '_ \\| __| |  _| | | |/ _ \\/ __|\n" +
                "/\\__/ / |_| |_| | (_| |  __/ | | | |_  | |   | | |  __/\\__ \\\n" +
                "\\____/ \\__|\\__,_|\\__,_|\\___|_| |_|\\__| \\_|   |_|_|\\___||___/\n" +
                "                                                            ");
        System.out.println("");
        Utils.printSlow("Its so messy in here...", 100 * debugMode);
        Utils.printSlow("so many students...", 100 * debugMode);
        Utils.printSlow("Why must he hide the marks here", 100 * debugMode);
        Utils.printSlow(Colours.YELLOW + "*An antivirus has appeared!*", 10 * debugMode);

        Utils.Sleep(200 * debugMode);
        Utils.clearScreen();

        System.out.print(Colours.RESET + "\n" +
                ".______        ___   .___________.___________. __       _______ \n" +
                "|   _  \\      /   \\  |           |           ||  |     |   ____|\n" +
                "|  |_)  |    /  ^  \\ `---|  |----`---|  |----`|  |     |  |__   \n" +
                "|   _  <    /  /_\\  \\    |  |        |  |     |  |     |   __|  \n" +
                "|  |_)  |  /  _____  \\   |  |        |  |     |  `----.|  |____ \n" +
                "|______/  /__/     \\__\\  |__|        |__|     |_______||_______|\n" +
                "                                                                ");

        System.out.print("\n   __,_,\n" +
                "  [_|_/ \n" +
                "   //\n" +
                " _//    __\n" +
                "(_|)   |@@|\n" +
                " \\ \\__ \\--/ __\n" +
                "  \\o__|----|  |   __\n" +
                "      \\ }{ /\\ )_ / _\\\n" +
                "      /\\__/\\ \\__O (__\n" +
                "     (--/\\--)    \\__/\n" +
                "     _)(  )(_\n" +
                "    `---''---`");

        int i = gameManager.calculateCombatPower(debugMode);

        Utils.clearScreen();

        System.out.print(Colours.RESET + "\n" +
                ".______        ___   .___________.___________. __       _______ \n" +
                "|   _  \\      /   \\  |           |           ||  |     |   ____|\n" +
                "|  |_)  |    /  ^  \\ `---|  |----`---|  |----`|  |     |  |__   \n" +
                "|   _  <    /  /_\\  \\    |  |        |  |     |  |     |   __|  \n" +
                "|  |_)  |  /  _____  \\   |  |        |  |     |  `----.|  |____ \n" +
                "|______/  /__/     \\__\\  |__|        |__|     |_______||_______|\n" +
                "                                                                ");

        System.out.print("\n   __,_,\n" +
                "  [_|_/ \n" +
                "   //\n" +
                " _//    __\n" +
                "(_|)   |@@|\n" +
                " \\ \\__ \\--/ __\n" +
                "  \\o__|----|  |   __\n" +
                "      \\ }{ /\\ )_ / _\\\n" +
                "      /\\__/\\ \\__O (__\n" +
                "     (--/\\--)    \\__/\n" +
                "     _)(  )(_\n" +
                "    `---''---`");
        int enemyCombatPower = 2;
        Utils.printSlow(Colours.RED_BRIGHT + "\nYour Combat Power is: " + i + "\n", 150 * debugMode);
        if (i < enemyCombatPower)
        {
            Utils.clearScreen();
            System.out.print("/\\_/\\___  _   _    / /  ___  ___  ___  / \\\n" +
                    "\\_ _/ _ \\| | | |  / /  / _ \\/ __|/ _ \\/  /\n" +
                    " / \\ (_) | |_| | / /__| (_) \\__ \\  __/\\_/ \n" +
                    " \\_/\\___/ \\__,_| \\____/\\___/|___/\\___\\/   ");
            return;
            //Lose condition ADD

        }
        else
        {
            System.out.print(Colours.PURPLE_BRIGHT + "");
            System.out.print("____    ____  ______    __    __     ____    __    ____  __  .__   __.  __   __  \n" +
                    "\\   \\  /   / /  __  \\  |  |  |  |    \\   \\  /  \\  /   / |  | |  \\ |  | |  | |  | \n" +
                    " \\   \\/   / |  |  |  | |  |  |  |     \\   \\/    \\/   /  |  | |   \\|  | |  | |  | \n" +
                    "  \\_    _/  |  |  |  | |  |  |  |      \\            /   |  | |  . `  | |  | |  | \n" +
                    "    |  |    |  `--'  | |  `--'  |       \\    /\\    /    |  | |  |\\   | |__| |__| \n" +
                    "    |__|     \\______/   \\______/         \\__/  \\__/     |__| |__| \\__| (__) (__) \n" +
                    "                                                                                 ");
        }

        Utils.Sleep(2000);
        Utils.printSlow(Colours.RESET + "\nPhew, looks like it's gone." ,25 * debugMode);
        Utils.printSlow(Colours.RESET + "But the antivirus knows you're here...", 25 * debugMode);
        Utils.printSlow(Colours.RESET + "You must act fast.", 25 * debugMode);
        Utils.Sleep(2000);
        Utils.printSlow("You've reached your file!", 25);
        Utils.printSlow("The rest of the game coming soon :)", 25);
        System.out.println("Thanks for playing!! the game is not done yet \n but thanks for testing");
        //Utils.printSlow("Ok... the file has been configured... what would yo like to do?", 25);
        //System.out.println(Colours.GREEN_BRIGHT + "Select an option to continue!");




    }
}
