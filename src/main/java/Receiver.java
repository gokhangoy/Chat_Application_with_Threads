import java.util.concurrent.BlockingQueue;

public class Receiver extends Player implements Runnable { //Thread Class

    Player player;
    PlayerManager playerManager;
    private int numberOfMessageSent = 0;

    public Receiver(BlockingQueue<String> sent, BlockingQueue<String> received, Player player, PlayerManager playerManager) {
        super(sent, received, player);
        this.player = player;
        this.playerManager = playerManager;
        new Thread(this, "Receiver").start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(250);
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