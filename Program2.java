import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        int i;
        int a[] = new int[20];
        int sent;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of packets:");
        int n = sc.nextInt();

        System.out.println("Enter the bucket capacity:");
        int bucket_capacity = sc.nextInt();

        System.out.println("Enter the output rate:");
        int rate = sc.nextInt();

        System.out.println("Enter the size of each packet:");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Clock\tPacketSize\tAccepted\tDropped\tSent\tRemaining");

        int bucket_remaining = 0;

        for (i = 0; i < n; i++) {
            int accept, dropped;
            if (a[i] != 0) {
                if (bucket_remaining + a[i] > bucket_capacity) {
                    accept = bucket_capacity - bucket_remaining;
                    dropped = a[i] - accept;
                    bucket_remaining = bucket_capacity;
                } else {
                    accept = a[i];
                    dropped = 0;
                    bucket_remaining += a[i];
                }
            } else {
                accept = 0;
                dropped = 0;
            }

            if (bucket_remaining != 0) {
                if (bucket_remaining < rate) {
                    sent = bucket_remaining;
                    bucket_remaining = 0;
                } else {
                    sent = rate;
                    bucket_remaining -= rate;
                }
            } else {
                sent = 0;
            }

            System.out.println((i + 1) + "\t" + a[i] + "\t\t" + accept + "\t\t" + dropped + "\t" + sent + "\t" + bucket_remaining);
        }
    }
}