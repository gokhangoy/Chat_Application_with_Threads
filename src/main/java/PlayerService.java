import java.util.concurrent.BlockingQueue;

public interface PlayerService { // Abstraction for Player

    String receiveMessage(BlockingQueue<String> sent);

    void sendMessage(Player player, String receivedMessage, BlockingQueue<String> sent, int numberOfMessageReceived);

    void initializationMessage(Player player, BlockingQueue<String> sent, String firstMessage);
}


