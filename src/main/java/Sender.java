import java.util.concurrent.BlockingQueue;

public class Sender extends Player implements Runnable {  //Thread Class

    Player player;
    PlayerManager playerManager;
    private int numberOfMessageSent = 0;
    private String firstMessage = null;

    public Sender(BlockingQueue<String> sent, BlockingQueue<String> received, Player player,
                  PlayerManager playerManager,
                  String firstMessage) {
        super(sent, received, player);
        this.player = player;
        this.playerManager = playerManager;
        this.firstMessage = firstMessage;
        new Thread(this, "Sender").start();
    }


    @Override
    public void run() {

        playerManager.initializationMessage(this, sent, firstMessage);
        numberOfMessageSent++;

        try {
            Thread.sleep(500);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }

        while (true) {
            String receivedMessage = playerManager.receiveMessage(received);
            playerManager.sendMessage(this, receivedMessage, sent, numberOfMessageSent);
            numberOfMessageSent++;
        }
    }
}



