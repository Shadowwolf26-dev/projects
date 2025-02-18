package util;

import javax.swing.*;

public class InstructionEvent extends Thread
{

    /*
    * Multithreaded event that controls instructions
    * Changes header text every ~2.5 seconds to allow player to read the text
    * */
    private JLabel text;

    public InstructionEvent(JLabel text)
    {
        this.text = text;
    }

    public void run()
    {
        sleep(2500);
        text.setText("Here are the instructions for the game");
        sleep(2500);
        text.setText("This game revolves around your choices...");
        sleep(2000);
        text.setText("As the ruling monarch of the world!");
        sleep(2000);
        text.setText("Manage your civilization well by clicking the buttons.");
        sleep(2000);
        text.setText("All the different stats will impact each other so be careful.");
        sleep(2000);
        text.setText("Avoid Regicide (or Asphyxiation) :D");

    }

    private void sleep(int milliseconds)
    {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
