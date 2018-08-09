package projectanarchy;

public class HitMessage extends Message
{
    public boolean Hit;

    public HitMessage(boolean hit)
    {
        super("Hit");
        this.Hit = hit;
    }
}
