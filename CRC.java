import java.util.Scanner;

public class CRC {
    static String msg;
    static String genPoly = "110010"; 
    static char t[] = new char[128];
    static char g[] = new char[128]; 
    static int mlen, glen;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the message in binary (0s and 1s): ");
        msg = sc.nextLine();
        mlen = msg.length();
        System.out.println("mlen = " + mlen);
        for (int i = 0; i < mlen; i++) {
            t[i] = msg.charAt(i);
        }
        System.out.print("Message bits (t[]): ");
        for (int i = 0; i < mlen; i++) {
            System.out.print("t[" + i + "]=" + t[i] + " ");
        }
        System.out.println();
        glen = genPoly.length();
        for (int i = 0; i < glen; i++) {
            g[i] = genPoly.charAt(i);
        }
        System.out.print("Generator polynomial (g[]): ");
        for (int i = 0; i < glen; i++) {
            System.out.print("g[" + i + "]=" + g[i] + " ");
        }
        System.out.println();
        System.out.println("glen = " + glen);

        for (int i = 0; i < glen - 1; i++) {
            t[mlen + i] = '0';
        }
        System.out.print("Message after appending zeros (t[]): ");
        for (int i = 0; i < mlen + glen - 1; i++) {
            System.out.print("t[" + i + "]=" + t[i] + " ");
        }
        System.out.println();
    }
}