package utils;

public class RoomIcon
{
    private String character;

    private String colour;
    private int x;
    private int y;

    public RoomIcon(String character, int x, int y)
    {
        this.character = character;
        this.x = x;
        this.y = y;
    }

    public RoomIcon(String character, String colour, int x, int y)
    {
        this.character = colour + character;
        this.x = x;
        this.y = y;
    }

    public void setCoordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
