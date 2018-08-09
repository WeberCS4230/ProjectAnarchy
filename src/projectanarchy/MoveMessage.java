package projectanarchy;

public class MoveMessage extends Message
{
    public int XCoordinate;
    public int YCoordinate;

    public MoveMessage(int xCoordinate, int yCoordinate)
    {
        super("Move");
        this.XCoordinate = xCoordinate;
        this.YCoordinate = yCoordinate;
    }
}
