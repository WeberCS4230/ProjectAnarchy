package projectanarchy;

public class ChatMessage extends Message
{
    public String ChatMessage;
    public ChatMessage(String chatMessage)
    {
        super("Chat");
        this.ChatMessage = chatMessage;
    }
}
