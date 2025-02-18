package utils;

import games.RockPaperScissors;
import games.TickTacToe;

public class GameManager
{
    RockPaperScissors rockPaperScissors = new RockPaperScissors();
    TickTacToe tickTacToe = new TickTacToe();
    boolean test = false;
    public int calculateCombatPower(int debugMode)
    {
        int x = 0;
        while (true)
        {
            int add = rockPaperScissors.rpc(debugMode);
            x += add;
            if (add == 0)
                break;
        }
        x += tickTacToe.main();

        return x;
    }
}
