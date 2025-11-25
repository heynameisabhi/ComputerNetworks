import java.util.Scanner;

public class Client {

    static int seq, ack;
    static int lastReceivedServerSeq;

    static Scanner sc = new Scanner(System.in);

    // First packet (User enters initial sequence number)
    static void firstPacket() {
        System.out.print("Enter Client initial sequence number: ");
        seq = sc.nextInt();
        ack = -1;    // nill

        System.out.println("\nClient side packet sent");
        System.out.println("sequence number - " + seq);
        System.out.println("Ack number – nill\n");
    }

    // Subsequent packets
    static void nextPacket() {
        seq = seq + 1;                     // next sequence number
        ack = lastReceivedServerSeq + 1;   // ack = received seq + 1

        System.out.println("Client side packet sent");
        System.out.println("sequence number - " + seq);
        System.out.println("Ack number – " + ack + "\n");
    }
}
