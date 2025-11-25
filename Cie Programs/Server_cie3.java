import java.util.Scanner;

public class Server {

    static int seq, ack;
    static int lastReceivedClientSeq;

    static Scanner sc = new Scanner(System.in);

    // First packet (User enters initial sequence number)
    static void firstPacket() {
        System.out.print("Enter Server initial sequence number: ");
        seq = sc.nextInt();
        ack = lastReceivedClientSeq + 1;   // ack = client seq + 1

        System.out.println("\nServer side packet sent");
        System.out.println("sequence number - " + seq);
        System.out.println("Ack number – " + ack + "\n");
    }

    // Subsequent packets
    static void nextPacket() {
        seq = seq + 1;                     // next seq number
        ack = lastReceivedClientSeq + 1;   // ack = received seq + 1

        System.out.println("Server side packet sent");
        System.out.println("sequence number - " + seq);
        System.out.println("Ack number – " + ack + "\n");
    }
}
