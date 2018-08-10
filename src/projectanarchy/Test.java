package projectanarchy;

import org.json.JSONObject;

import java.io.*;
import java.net.*;

public class Test implements Runnable {

    private static final String MODULE = "ProjectAnarchy";

    public static void main(String[] args) throws IOException {

        Test client1 = new Test("localhost", "client1");
        new Thread(client1).start();
        Test client2 = new Test("localhost", "client2");
        new Thread(client2).start();
    }

    private PrintWriter out;

    private String name;

    private void send(JSONObject message) {
    	out.println(message.toString());
    	out.flush();
    }

    public Test(String host, String name) throws IOException {
    	this.name = name;

    	Socket socket = new Socket(host, 8989);

    	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    	out = new PrintWriter(socket.getOutputStream());

    	new Thread(() -> {
    	    try {
		        while (true) {
			        System.out.println(name + ": " + in.readLine());
		        }
	        } catch (IOException e) {
    	    	e.printStackTrace();
	        }
    	}).start();
    }

    @Override
    public void run() {
	    JSONObject login1 = new JSONObject("{ type: 'login', message: { username: '" + name + "' }}");

	    JSONObject testHit = new JSONObject(MessageFactory.getHitMessage(new HitMessage(true)));
	    JSONObject testChat = new JSONObject(MessageFactory.getChatMessage(new ChatMessage("This is the chat text")));
	    JSONObject testMove = new JSONObject(MessageFactory.getMoveMessage(new MoveMessage(0, 0)));
	    JSONObject testStart = new JSONObject(MessageFactory.getStartMessage(new StartMessage()));
	    JSONObject testWin = new JSONObject(MessageFactory.getWinMessage(new WinMessage()));

	    send(login1);
	    send(testHit);
	    send(testChat);
	    send(testMove);
	    send(testStart);
	    send(testWin);
    }
}
