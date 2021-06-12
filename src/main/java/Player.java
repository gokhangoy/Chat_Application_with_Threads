import java.util.concurrent.BlockingQueue;

public class Player implements Entity {

    private String firstName;
    private String lastName;
    public BlockingQueue<String> sent;
    public BlockingQueue<String> received;


    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Player(BlockingQueue<String> sent, BlockingQueue<String> received, Player player) {
        this.sent = sent;
        this.received = received;
        this.firstName = player.getFirstName();
        this.lastName = player.getLastName();

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}


