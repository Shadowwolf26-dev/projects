package games;

import utils.Colours;
import utils.Utils;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TickTacToe
{
    char[][] board;
    int[][] mirrorBoard;
    boolean win;
    public int main()
    {
        win = false;

        Scanner scanner = new Scanner(System.in);
        board = new char[3][3];
        mirrorBoard = new int[3][3];
        System.out.println("\n" + mirrorBoard[0][0]);
        Utils.Sleep(1000);
        System.out.println("\nThis is your board:");

        draw();
        while (!win)
        {
            move(scanner, Symbol.X);
            //moveAI(Symbol.X);
            win = win();
            if (win || tie())
                break;
            Utils.printSlow(Colours.YELLOW_BRIGHT + "Your enemy is playing..." + Colours.RESET, 25);
            moveAI(Symbol.O);
            draw();
            win = win();
            if (win || tie())
                break;
        }

        if (tie())
            return 1;

        switch (whoWon())
        {
            case X:
                return 3;
            case O:
            default:
                return 0;
        }

    }

    private void draw()
    {
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                System.out.print(board[x][y]);
            }
            System.out.print("\n");
        }
    }

    private void move(Scanner scanner, Symbol symbol)
    {
        int x;
        int y;
        while (true)
        {
            x = getNumber(scanner, "Which column would you like to play in? [0, 1, 2]", 0, 2);
            y = getNumber(scanner, "Which row would you like to play in? [0, 1, 2]", 0, 2);
            if (mirrorBoard[x][y] == 0)
            {
                break;
            }
            else
                System.out.println(Colours.RED + "Please enter a space that has not been taken!" + Colours.RESET);
        }
        switch (symbol)
        {
            case O:
                board[x][y] = 'O';
                mirrorBoard[x][y] = -1;
                break;
            case X:
                board[x][y] = 'X';
                mirrorBoard[x][y] = 1;
                break;
        }
        draw();
    }

    private void moveAI(Symbol symbol)
    {
        int value;
        char character;
        if (symbol == Symbol.X)
        {
            value = 1;
            character = 'X';
        }
        else
        {
            value = -1;
            character = 'O';
        }
        for (int y = 0; y < 3; y ++)
        {
            for (int x = 0; x < 2; x++)
            {
                if (mirrorBoard[x][y] * mirrorBoard[x + 1][y] == 1)
                {
                    if (x == 0 && mirrorBoard[x+2][y] == 0)
                    {
                        board[x+2][y] = character;
                        mirrorBoard[x+2][y] = value;
                        return;
                    }
                    else if (x == 1 && mirrorBoard[x-1][y] == 0)
                    {
                        board[x-1][y] = character;
                        mirrorBoard[x-1][y] = value;
                        return;

                    }

                }
            }
        }
        for (int x = 0; x < 2; x++)
        {
            for (int y = 0; y < 2; y++)
            {
                if (mirrorBoard[x][y] * mirrorBoard[x][y+1] == 1)
                {
                    if (y == 0 && mirrorBoard[x][y+2] == 0)
                    {
                        board[x][y+2] = character;
                        mirrorBoard[x][y+2] = value;
                        return;

                    }
                    else if (y == 1 && mirrorBoard[x][y-1] == 0)
                    {
                        board[x][y-1] = character;
                        mirrorBoard[x][y-1] = value;
                        return;

                    }
                }
            }
        }

        if (mirrorBoard[0][0] * mirrorBoard[1][1] == 1 && mirrorBoard[2][2] == 0)
        {
            board[2][2] = character;
            mirrorBoard[2][2] = value;
            return;
        }
        else if (mirrorBoard[1][1] * mirrorBoard[2][2] == 1 && mirrorBoard[0][0] == 0)
        {
            board[0][0] = character;
            mirrorBoard[0][0] = value;
            return;
        }
        else if (mirrorBoard[2][0] * mirrorBoard[1][1] == 1 && mirrorBoard[0][2] == 0)
        {
            board[0][2] = character;
            mirrorBoard[0][2] = value;
            return;
        }
        else if (mirrorBoard[1][1] * mirrorBoard[0][2] == 1 && mirrorBoard[2][0] == 0)
        {
            board[2][0] = character;
            mirrorBoard[2][0] = value;
            return;
        }
        if (mirrorBoard[1][1] == 0)
        {
            board[1][1] = character;
            mirrorBoard[1][1] = value;
            return;
        }
        Random random = new Random();
        while (true)
        {
            int x = random.nextInt(0, 3);
            int y = random.nextInt(0, 3);
            System.out.println("[DEBUG]" + x + " " + y);
            if (mirrorBoard[x][y] == 0)
            {
                board[x][y] = character;
                mirrorBoard[x][y] = value;
                return;
            }
        }

    }

    private Symbol whoWon() {
        for (int[] row : mirrorBoard) {
            if (row[0] == row[1] && row[1] == row[2] && row[0] != 0) {
                if (row[0] == 1) {
                    return Symbol.X;
                } else
                    return Symbol.O;
            }
        }
        for (int x = 0; x < 3; x++) {
            if (mirrorBoard[x][0] == mirrorBoard[x][1] &&
                    mirrorBoard[x][1] == mirrorBoard[x][2] &&
                    mirrorBoard[x][0] != 0) {
                if (mirrorBoard[x][0] == 1)
                    return Symbol.X;
                else
                    return Symbol.O;
            }
        }
        if (mirrorBoard[0][0] == mirrorBoard[1][1] &&
                mirrorBoard[1][1] == mirrorBoard[2][2] && mirrorBoard[0][0] != 0)
        {
            if (mirrorBoard[0][0] == 1)
                return Symbol.X;
            else
                return Symbol.O;
        }

        if (mirrorBoard[0][2] == mirrorBoard[1][1] && mirrorBoard[1][1] == mirrorBoard[2][0] &&
                mirrorBoard[0][2] != 0)
        {
            if (mirrorBoard[0][0] == 1)
                return Symbol.X;
            else
                return Symbol.O;
        }
        else
            return null;
    }

    private boolean win()
    {
        for (int[] row : mirrorBoard)
        {
            if (row[0] == row[1] && row[1] == row[2] && row[0] != 0)
                return true;
        }
        for (int x = 0; x < 3; x++)
        {
            System.out.println("[DEBUG]" + x);
            if (mirrorBoard[x][0] == mirrorBoard[x][1] &&
                    mirrorBoard[x][1] == mirrorBoard[x][2] &&
                    mirrorBoard[x][0] != 0)
                return true;
        }
        System.out.println("[DEBUG] Diagonal 1");
        if (mirrorBoard[0][0] == mirrorBoard[1][1] &&
                mirrorBoard[1][1] == mirrorBoard[2][2] && mirrorBoard[0][0] != 0)
            return true;
        System.out.println("[DEBUG] Diagonal 2");

        if (mirrorBoard[0][2] == mirrorBoard[1][1] && mirrorBoard[1][1] == mirrorBoard[2][0] &&
                mirrorBoard[0][2] != 0)
            return true;
        else
            return false;
    }

    private int getNumber(Scanner scanner, String s, int min, int max)
    {
        while (true)
        {
            System.out.println(s);
            try
            {
                int i = scanner.nextInt();
                if (!(i < min) && !(i > max))
                    return i;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid Response");
            }
        }

    }

    private boolean tie()
    {
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                if (mirrorBoard[x][y] == 0)
                    return false;
            }
        }
        return true;
    }

    enum Symbol
    {
        X,
        O
    }
}
