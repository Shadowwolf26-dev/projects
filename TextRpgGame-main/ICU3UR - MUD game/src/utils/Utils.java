package utils;

import java.util.concurrent.TimeUnit;

public class Utils
{
    public static final void clearScreen()
    {
        for (int x = 0; x < 50; x++) System.out.print("\n");
    }

    public static final void printSlow(String output, long sleepTime)
    {
        char[] chars = output.toCharArray();
        for (int x = 0; x < chars.length; x++)
        {
            System.out.print(chars[x]);
            try {
                TimeUnit.MILLISECONDS.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.print("\n");
    }

    public static final void Sleep(long miliseconds)
    {
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
