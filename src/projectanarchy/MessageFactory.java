package projectanarchy;

import java.io.StringWriter;
import java.util.function.Consumer;
import org.json.JSONWriter;

public class MessageFactory
{
	private static String moduleString = "Battleship2";

	private static String json(String type, Consumer<JSONWriter> message)
	{
		StringWriter stringWriter = new StringWriter();
		JSONWriter writer = new JSONWriter(stringWriter);
		writer.object();
		writer.key("type").value(type);
		writer.key("message");
		message.accept(writer);
		writer.endObject();
		return stringWriter.toString();
	}
	
	private static String action(String action, Consumer<JSONWriter> message)
	{
		return json("application", writer ->
		{
			writer.object();
			writer.key("module").value(moduleString);
			writer.key("action").value(action);
			message.accept(writer);
			writer.endObject();
		});
	}
	
	public static String getChatMessage(ChatMessage chatMessage)
	{
		return json("chat", writer ->
		{
			writer.value(chatMessage.ChatMessage);
		});
	}
	
	public static String getHitMessage(HitMessage hitMessage)
	{
		return action("hit", writer ->
		{
			writer.key("hit").value(hitMessage.Hit);
		});
	}
	
	public static String getMoveMessage(MoveMessage moveMessage)
	{
		return action("move", writer ->
		{
			writer.key("x").value(moveMessage.XCoordinate);
			writer.key("y").value(moveMessage.YCoordinate);
		});
	}
	
	public static String getStartMessage(StartMessage startMessage)
	{
		return action("start", writer ->
		{
			startMessage.getClass();
		});
	}
	
	public static String getWinMessage(WinMessage winMessage)
	{
		return action("win", writer ->
		{
			winMessage.getClass();
		});
	}
}
