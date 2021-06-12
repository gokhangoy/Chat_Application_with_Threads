import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    //The capacity needs to be 1 to allow only mutual message sending.
    // One will put the message while the other will take it.
    public static final int capacityOfQueue = 1;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("------------------------Start of the Application----------------------------");

         /*As a result of my research on this subject on the internet, it was thought that it was very correct to use the
         BlockingQueue structure, which handles the thread synchronization itself. However, since it is an interface,
         a class that implements this interface had to be used in order to generate a reference.
         In this context, the ArrayBlockingQueue class is used.*/


        PlayerManager playerManager = new PlayerManager();
        BlockingQueue<String> player1ToPlayer2 = new ArrayBlockingQueue<String>(capacityOfQueue);
        BlockingQueue<String> player2ToPlayer1 = new ArrayBlockingQueue<String>(capacityOfQueue);


        Player initiator = new Player("Gökhan", "Göy");
        Player receiver = new Player("Nihat", "Baz");


        new Sender(player1ToPlayer2, player2ToPlayer1, initiator, playerManager, "Hello");
        new Receiver(player2ToPlayer1, player1ToPlayer2, receiver, playerManager);


    }
}



