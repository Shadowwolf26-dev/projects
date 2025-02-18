package rooms;

import utils.Colours;
import utils.RoomIcon;
import utils.RoomMaker;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RoomOne
{
    DestinationOne destinationOne = new DestinationOne();
    public void main(RoomMaker roomMaker, Scanner scanner, int debugMode)
    {
        System.out.println("");
        roomMaker.makeRoom(100, 5,
                new RoomIcon("Where would you like to go?", Colours.GREEN_BRIGHT, 2, 1),
                new RoomIcon("[1] STUDENT_FILES", Colours.BLUE, 2, 2),
                new RoomIcon("[2] ANTIVIRUS", Colours.BLUE, 2, 3),
                new RoomIcon("[3] PEEL_DISTRICT_SCHOOL_BOARD", Colours.BLUE, 2, 4));

        if (debugMode == 0)
        {
            destinationOne.main(roomMaker, debugMode);
            return;
        }

        switch (getNumber(scanner, 1, 1)) //change max to 3 later**
        {
            case 1:
                System.out.println("Entering Student Files");
                destinationOne.main(roomMaker, debugMode);
                break;
            case 2:
                System.out.println("Entering Antivirus");
                break;
            case 3:
                System.out.println("Entering PDSB database");
                break;
        }

    }
    private int getNumber(Scanner scanner, int min, int max)
    {
        System.out.print("\n");
        while (true)
        {
            System.out.println(Colours.GREEN_BRIGHT + "Please select an option");
            int i;
            try
            {
                i = scanner.nextInt();
                if (i < min || i > max)
                {
                    scanner.reset();
                    continue;
                }
                return i;
            }
            catch (InputMismatchException exception)
            {

            }
        }
    }

}
