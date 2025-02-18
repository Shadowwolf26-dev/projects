package rooms;

import utils.Colours;
import utils.RoomMaker;
import utils.Utils;

import java.util.Scanner;

public class StartRoom
{
    public void main(Scanner scanner, int debugMode)
    {
        Utils.clearScreen();
        System.out.print(Colours.CYAN_BRIGHT +
                "          _______  _        _______  _______  _______  _______  _ \n" +
                "|\\     /|(  ____ \\( \\      (  ____ \\(  ___  )(       )(  ____ \\( )\n" +
                "| )   ( || (    \\/| (      | (    \\/| (   ) || () () || (    \\/| |\n" +
                "| | _ | || (__    | |      | |      | |   | || || || || (__    | |\n" +
                "| |( )| ||  __)   | |      | |      | |   | || |(_)| ||  __)   | |\n" +
                "| || || || (      | |      | |      | |   | || |   | || (      (_)\n" +
                "| () () || (____/\\| (____/\\| (____/\\| (___) || )   ( || (____/\\ _ \n" +
                "(_______)(_______/(_______/(_______/(_______)|/     \\|(_______/(_)");

        Utils.printSlow("\n " + Colours.GREEN_BRIGHT + "[Type anything to begin.]", 100 * debugMode);
        String s = "";
        if (debugMode != 0)
            s = scanner.nextLine();
        Utils.clearScreen();
        System.out.print(Colours.WHITE_BRIGHT + "\n" +
                "_________ _        _______ _________ _______           _______ __________________ _______  _        _______ \n" +
                "\\__   __/( (    /|(  ____ \\\\__   __/(  ____ )|\\     /|(  ____ \\\\__   __/\\__   __/(  ___  )( (    /|(  ____ \\\n" +
                "   ) (   |  \\  ( || (    \\/   ) (   | (    )|| )   ( || (    \\/   ) (      ) (   | (   ) ||  \\  ( || (    \\/\n" +
                "   | |   |   \\ | || (_____    | |   | (____)|| |   | || |         | |      | |   | |   | ||   \\ | || (_____ \n" +
                "   | |   | (\\ \\) |(_____  )   | |   |     __)| |   | || |         | |      | |   | |   | || (\\ \\) |(_____  )\n" +
                "   | |   | | \\   |      ) |   | |   | (\\ (   | |   | || |         | |      | |   | |   | || | \\   |      ) |\n" +
                "___) (___| )  \\  |/\\____) |   | |   | ) \\ \\__| (___) || (____/\\   | |   ___) (___| (___) || )  \\  |/\\____) |\n" +
                "\\_______/|/    )_)\\_______)   )_(   |/   \\__/(_______)(_______/   )_(   \\_______/(_______)|/    )_)\\_______)\n" +
                "                                                                                                            ");
        Utils.printSlow(Colours.YELLOW_BRIGHT + "\n Yellow text is important, make sure you read it!", 50 * debugMode);
        Utils.printSlow(Colours.GREEN_BRIGHT + "\n [Green text means you have a decision to make.]\n", 50 * debugMode);
        Utils.printSlow(Colours.GREEN_BRIGHT + "[Type anything to start]" + Colours.RESET, 50 * debugMode);
        if (debugMode != 0)
            s = scanner.next();
        Utils.clearScreen();
    }


}
