import rooms.RoomOne;
import rooms.StartRoom;
import utils.Colours;
import utils.RoomIcon;
import utils.RoomMaker;

import java.util.Scanner;
import java.io.IOException;

public class Main
{
    private static StartRoom startRoom = new StartRoom();
    private static RoomMaker roomMaker = new RoomMaker();
    private static RoomOne roomOne = new RoomOne();
    private static String[] argsSave = new String[0];

    public static void main(String[] args)
    {
        argsSave = args;
        int debugMode = 1;

        Scanner scanner = new Scanner(System.in);
        startRoom.main(scanner, debugMode);
        roomMaker.makeRoom(100, 10,
                new RoomIcon("X", 50, 5),
                new RoomIcon("[ANTIVIRUS]", 55, 3),
                new RoomIcon("[STUDENT_FILES]", 35, 4),
                new RoomIcon("[PEEL DISTRICT SCHOOL BOARD]", 65, 7));
        roomOne.main(roomMaker, scanner, debugMode);
    }

    public static void run()
    {
        main(argsSave);
    }
}