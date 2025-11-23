import java.util.*;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        

        System.out.println("Enter the number of packets");
        int num = sc.nextInt();
        System.out.println("Enter the bucket capacity");
        int capacity = sc.nextInt();
        System.out.println("Enter the output");
        int outputrate = sc.nextInt();
        System.out.println("Enter the size of the packet");
        int packet[] = new int[num];
        for (i = 0; i < num; i++) {
            packet[i] = sc.nextInt();

        }
        System.out.println("CLOCK \t PACKET SIZE \t DROPPEED \t RECIEVED \t SENT \t REMAINING");
        int bucket_remaining = 0, rev, dropped,sent;
        for (i = 0; i < num; i++) {
            if (packet[i] != 0) {
                if (bucket_remaining + packet[i] > capacity) {

                    rev = capacity - bucket_remaining;
                    dropped = packet[i] - rev;

                   bucket_remaining = capacity;

                } else {
                    rev = packet[i];
                    bucket_remaining += packet[i];
                }

            } else
                rev = 0;
                dropped = 0;

            if (bucket_remaining != 0) {
                if (bucket_remaining < outputrate) {

                    sent = bucket_remaining;
                    bucket_remaining = 0;
                }

                else {
                    sent = outputrate;
                    bucket_remaining = bucket_remaining - outputrate;
                }
            } else
                sent = 0;
            
                System.out.println(+i + "\t\t" + packet[i] + "\t\t"+dropped+"\t"+ rev + "\t" + sent + "\t" + bucket_remaining + "\t");

        }
    }
}
