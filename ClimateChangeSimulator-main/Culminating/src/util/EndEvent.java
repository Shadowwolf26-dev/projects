package util;

import java.io.File;

public class EndEvent extends Thread
{
    private boolean dead;
    public EndEvent(boolean dead)
    {
        //Constructor for EndEvent Thread Object
        this.dead = dead;
    }
    public void run()
    {
        /*
        * Checks to confirm if the user has died; if that is true:
        * - Deletes gameData.txt
        * - Deletes gameDay.txt
        * - Pauses for 2.5 seconds
        * - Ends program
        * */
        if (dead)
        {
            File f = new File("gameData.txt");
            File f2 = new File("gameDay.txt");
            if (f.delete()) {
                System.out.println("Deleted the file: " + f.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
            if (f2.delete()) {
                System.out.println("Deleted the file: " + f2.getName());
            } else {
                System.out.println("Failed to delete the file.");
            }
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);

        }
    }
}
