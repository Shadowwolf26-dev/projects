package games;

import jdk.jshell.execution.Util;
import utils.Colours;
import utils.Utils;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors
{
    public int rpc(int debugMode)
    {
        Utils.printSlow(Colours.RESET + "\nWelcome to Rock Paper Scissors!", 50 * debugMode);
        Utils.printSlow("Select one of the following: ", 50 * debugMode);
        System.out.println(Colours.CYAN_BRIGHT + "[1] Rock");
        System.out.println(Colours.CYAN_BRIGHT + "[2] Paper");
        System.out.println(Colours.CYAN_BRIGHT + "[3] Scissors");
        System.out.println(Colours.RESET + "-----------");
        Scanner scanner = new Scanner(System.in);
        Option option = Option.NULL;
        switch (getNumber(scanner, 1, 3))
        {
            case 1:
                option = Option.ROCK;
                break;
            case 2:
                option = Option.PAPER;
                break;
            case 3:
                option = Option.SCISSORS;
                break;
        }

        Option AIoption = Option.NULL;
        Random random = new Random();
        int randomNumber = random.nextInt(1, 3);
        random.setSeed(123456789);
        switch (randomNumber)
        {
            case 1:
                AIoption = Option.ROCK;
                break;
            case 2:
                AIoption = Option.PAPER;
                break;
            case 3:
                AIoption = Option.SCISSORS;
                break;
        }

        Utils.printSlow(Colours.YELLOW_BRIGHT + "You picked " + option, 100 * debugMode);
        Utils.printSlow(Colours.YELLOW_BRIGHT + "Your opponent picked " + AIoption, 100 * debugMode);


        switch (win(option, AIoption))
        {
            case WIN:
                System.out.println("");
                System.out.println("You Win!!!");
                System.out.println("");
                return 2;
            case TIE:
                System.out.println("");
                System.out.println("You Tied!!!");
                System.out.println("");
                return 1;
            case LOSS:
            default:
                System.out.println("");
                System.out.println("You Lost!!!");
                System.out.println("");
                return 0;
        }
    }

    private Result win(Option playerOption, Option computerOption)
    {

        if (playerOption == Option.ROCK)
        {
            if (computerOption == Option.PAPER)
                return Result.LOSS;
            else if (computerOption == Option.SCISSORS)
                return Result.WIN;
            else if (computerOption == Option.ROCK)
                return Result.TIE;
        }
        else if (playerOption == Option.PAPER)
        {
            if (computerOption == Option.SCISSORS)
                return Result.LOSS;
            else if (computerOption == Option.ROCK)
                return Result.WIN;
            else if (computerOption == Option.PAPER)
                return Result.TIE;
        }
        else if (playerOption == Option.SCISSORS)
        {
            if (computerOption == Option.ROCK)
                return Result.LOSS;
            else if (computerOption == Option.PAPER)
                return Result.WIN;
            else if (computerOption == Option.SCISSORS)
                return Result.TIE;
        }

        return Result.LOSS;
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
                    continue;
                return i;
            }
            catch (InputMismatchException exception)
            {

            }
        }
    }

    enum Option
    {
        ROCK,
        PAPER,
        SCISSORS,
        NULL
    }

    enum Result
    {
        WIN,
        LOSS,
        TIE
    }
}
