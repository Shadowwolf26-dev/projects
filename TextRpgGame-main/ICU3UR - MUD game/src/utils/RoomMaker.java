package utils;

public class RoomMaker
{
    public void makeRoom(int sizeHorizontal, int sizeVertical, RoomIcon... roomIcons)
    {
        for (int x = 0; x < sizeHorizontal; x++)
        {
            System.out.print("-");
        }
        for (int y = 0; y < sizeVertical; y++)
        {
            String output = Colours.RESET + "|";
            for (int x = 1; x < sizeHorizontal - 1; x++)
            {
                String character = " ";
                for (RoomIcon roomIcon : roomIcons)
                {
                    if (x == roomIcon.getX() && y == roomIcon.getY())
                    {
                        character = roomIcon.getCharacter();
                        x += character.length() - 1;
                    }
                }
                output = output + character;
            }
            output = output + Colours.RESET + "|";
            System.out.println(output);
        }
        for (int x = 0; x < sizeHorizontal; x++)
        {
            System.out.print("-");
        }
    }


}
