import java.util.concurrent.BlockingQueue;

public class PlayerManager implements PlayerService {

    String receivedMessage;

    @Override
    public String receiveMessage(BlockingQueue<String> received) {

        try {
            receivedMessage = received.take();

        } catch (InterruptedException exception) {
            System.out.println("Interrupted Exception caught");
        }

        return receivedMessage;
    }


    @Override
    public void sendMessage(Player player, String receivedMessage, BlockingQueue<String> sent, int numberOfMessageReceived) {

        String respondToTheMessage = receivedMessage + numberOfMessageReceived;

        try {
            sent.put(respondToTheMessage);
            System.out.println(player.getFirstName() + " " + player.getLastName() + " " + " sent message:\t"
                    + respondToTheMessage);
            Thread.sleep(1000);

        } catch (InterruptedException exception) {

            System.out.println("Interrupted Exception caught");
        }

        //Stop condition.
        if (numberOfMessageReceived == 9) {
            System.out.println("\n------------------------End of the Application----------------------------");
            System.exit(0);
        }

    }

    //This method only sends the initialization message which is hardly given as "Hello"
    @Override
    public void initializationMessage(Player player, BlockingQueue<String> sent, String firstMessage) {

        try {
            sent.put(firstMessage);
            System.out.println(player.getFirstName() + " " + player.getLastName() + " " + " sent message:\t" +
                    firstMessage);

        } catch (InterruptedException interrupted) {
            System.out.println("Interrupted Exception caught");
        }
    }
}