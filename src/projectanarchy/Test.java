package projectanarchy;

import org.json.JSONObject;

public class Test extends Handler{

    private static String module= "Battleship2";

    public static void main(String[] args){

        JSONObject login1 = new JSONObject("{ type: 'login', message: { username: 'client1' }}");
        JSONObject login2 = new JSONObject("{ type: 'login', message: { username: 'client2' }}");

        JSONObject testHit = new JSONObject(MessageFactory.getHitMessage(new HitMessage(true)));
        JSONObject testChat = new JSONObject(MessageFactory.getChatMessage(new ChatMessage("This is the chat text")));
        JSONObject testMove = new JSONObject(MessageFactory.getMoveMessage(new MoveMessage(0, 0)));
        JSONObject testStart = new JSONObject(MessageFactory.getStartMessage(new StartMessage()));
        JSONObject testWin = new JSONObject(MessageFactory.getWinMessage(new WinMessage()));



        Test client1 = new Test("8989");
        client1.start();
        Test client2 = new Test("8989");
        client2.start();

        client1.broadcast(login1, module);
        client2.broadcast(login2, module);
        client1.broadcast(testHit, module);
        client2.broadcast(testHit, module);
        client1.broadcast(testChat, module);
        client2.broadcast(testChat, module);
        client1.broadcast(testMove, module);
        client2.broadcast(testMove, module);
        client1.broadcast(testStart, module);
        client2.broadcast(testStart, module);
        client1.broadcast(testWin, module);
        client2.broadcast(testWin, module);

    }

    public Test(String portString) {
        super(portString);
    }

    @Override
    protected void handle(JSONObject message) {

    }
}
